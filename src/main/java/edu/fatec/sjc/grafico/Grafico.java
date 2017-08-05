package edu.fatec.sjc.grafico;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

@SuppressWarnings("serial")
public class Grafico extends JFrame {

	public Grafico(String applicationTitle, String chartTitle, String x, String y, DefaultCategoryDataset ds ) {
		super(applicationTitle);
		JFreeChart jfreechart = ChartFactory.createLineChart(chartTitle,x, y, ds,
				PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setRangePannable(true);
        categoryplot.setRangeGridlinesVisible(false);    
        
        ChartUtilities.applyCurrentTheme(jfreechart);
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setBaseShapesVisible(true);
        lineandshaperenderer.setDrawOutlines(true);
        lineandshaperenderer.setUseFillPaint(true);
        lineandshaperenderer.setBaseFillPaint(Color.white);
        lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F));
        lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
        lineandshaperenderer.setSeriesStroke(1, new BasicStroke(3F));
        lineandshaperenderer.setSeriesOutlineStroke(1, new BasicStroke(2.0F));
        lineandshaperenderer.setSeriesPaint(2, Color.YELLOW);
        lineandshaperenderer.setSeriesStroke(2, new BasicStroke(3F));
        lineandshaperenderer.setSeriesOutlineStroke(2, new BasicStroke(2.0F));
		
		ChartPanel chartPanel = new ChartPanel(jfreechart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
		setContentPane(chartPanel);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	

	
	//EXEMPLO DE COMO CRIAR
	public static void main( String[ ] args ) {
		Desenho d = new Desenho();
		
		Menina m = new Menina();
		double[] max = m.getPesoMax2a5();
		double[] min = m.getPesoMin2a5();
		DefaultCategoryDataset ds = d.getDs(2, 5, min, max);
		ds.addValue(10.15, "paciente", "3/2");
		ds.addValue(11.5, "paciente", "3/3");
		
		
		Grafico chart = new Grafico(
	         "Gráfico" ,
	         "Perímetro Cefálico X Idade \n0 a 2 anos", "IDADE", "Perímetro Cefálico (cm)", ds);

	      chart.pack( );
	      RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	   }

}
