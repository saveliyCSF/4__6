package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class GUI extends JDialog {
    private JPanel panelGUI;
    private JPanel panelChart;
    private JTable tableSortElements;
    private JButton buttonAddCol;
    private JButton shakerSortButton;
    private JButton bubbleSortButton;
    private JTextField maxSizeTF;
    private DefaultTableModel defaultTableModel;

    private JButton startTest;
    private JScrollPane scrollChartArea;
    private JPanel chartArea;
    private JButton startSortedTest;
    private XYSeriesCollection series = new XYSeriesCollection();
    private XYSeriesCollection seriesTime = new XYSeriesCollection();
    private ChartPanel panel = null;
    private ChartPanel panel2 = null;

    public GUI() {
        setContentPane(panelGUI);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(1500, 800);
        Object[] columns = {"1"};
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(columns);
        tableSortElements.setModel(defaultTableModel);
        defaultTableModel.addRow(new Object[1]);

        panel = new ChartPanel(createChartChgCnt(series));
        panel2 = new ChartPanel(createChartTime(seriesTime));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartArea.setLayout(new FlowLayout());
        chartArea.add(panel);
        chartArea.add(panel2);

        series.addSeries(new XYSeries("cmp_bubble"));
        series.addSeries(new XYSeries("chg_bubble"));
        series.addSeries(new XYSeries("cmp_shaker"));
        series.addSeries(new XYSeries("chg_shaker"));
        seriesTime.addSeries(new XYSeries("time_bubble"));
        seriesTime.addSeries(new XYSeries("time_shaker"));


//        XYSeries s = new XYSeries("SIN");
//        for (double i = 0; i < 10; i += 0.01) {
//            s.add(i, Math.sin(i));
//        }
//        series.addSeries(s);

        startTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int size = 0;
                try {
                    size = Integer.parseInt(maxSizeTF.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Не число", "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (size <= 0) {
                    JOptionPane.showMessageDialog(null, "Не положительное число", "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    ExperimentInfo result = Experiment.experiment(new RandomGenerator(-1000, 1000), size);

                    Experiment.applyBubbleCmpLine(result, series.getSeries(0));
                    Experiment.applyBubbleChgLine(result, series.getSeries(1));
                    Experiment.applyShakerCmpLine(result, series.getSeries(2));
                    Experiment.applyShakerChgLine(result, series.getSeries(3));
                    Experiment.applyBubbleTimeLine(result, seriesTime.getSeries(0));
                    Experiment.applyShakerTimeLine(result, seriesTime.getSeries(1));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка в эксперименте", "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });

        startSortedTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int size = 0;
                try {
                    size = Integer.parseInt(maxSizeTF.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Не число", "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (size <= 0) {
                    JOptionPane.showMessageDialog(null, "Не положительное число", "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    ExperimentInfo result = Experiment.experiment(new OrderedGenerator(), size);

                    Experiment.applyBubbleCmpLine(result, series.getSeries(0));
                    Experiment.applyBubbleChgLine(result, series.getSeries(1));
                    Experiment.applyShakerCmpLine(result, series.getSeries(2));
                    Experiment.applyShakerChgLine(result, series.getSeries(3));
                    Experiment.applyBubbleTimeLine(result, seriesTime.getSeries(0));
                    Experiment.applyShakerTimeLine(result, seriesTime.getSeries(1));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка в эксперименте", "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }
        });


        buttonAddCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultTableModel.addColumn(defaultTableModel.getColumnCount() + 1);
            }
        });
        shakerSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer[] arr = new Integer[defaultTableModel.getColumnCount()];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(defaultTableModel.getValueAt(0, i).toString());
                }
                System.out.println(arr);
                ShakerSort.sortInfo(arr);
                System.out.println(arr);
                for (int i = 0; i < arr.length; i++) {
                    defaultTableModel.setValueAt(arr[i], 0, i);
                }
            }
        });

        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer[] arr = new Integer[defaultTableModel.getColumnCount()];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(defaultTableModel.getValueAt(0, i).toString());
                }
                System.out.println(arr);
                BubbleSort.sortInfo(arr);
                System.out.println(arr);
                for (int i = 0; i < arr.length; i++) {
                    defaultTableModel.setValueAt(arr[i], 0, i);
                }
            }
        });

    }

    private static JFreeChart createChartChgCnt(XYSeriesCollection series) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart(
                "Сравнения vs Обмены", "Размер массива", "Количество",
                series
        );
        XYPlot plot = jFreeChart.getXYPlot();
        var renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        return jFreeChart;
    }

    private static JFreeChart createChartTime(XYSeriesCollection series) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart(
                "Время vs Время", "Размер массива", "Время",
                series
        );
        XYPlot plot = jFreeChart.getXYPlot();
        var renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        return jFreeChart;
    }
}
