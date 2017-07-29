package edu.fatec.sjc.grafico;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

@SuppressWarnings("serial")
public class Grafico extends ApplicationFrame {

	public Grafico(String applicationTitle, String chartTitle, String x, String y, DefaultCategoryDataset ds ) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle,x, y, ds,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
		setContentPane(chartPanel);
	}

	
	//EXEMPLO DE COMO CRIAR
	public static void main( String[ ] args ) {
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		ds.addValue(50, "padrão", "13");
		ds.addValue(45, "você", "13");
		ds.addValue(51, "padrão", "13/1");
		ds.addValue(45, "você", "13/1");
		ds.addValue(51, "padrão", "13/2");
		ds.addValue(46, "você", "13/2");
		ds.addValue(51, "padrão", "13/3");
		ds.addValue(45, "você", "13/3");
		ds.addValue(51, "padrão", "13/4");
		ds.addValue(51, "padrão", "13/5");
		ds.addValue(51, "padrão", "13/6");
		ds.addValue(51, "padrão", "13/7");
		ds.addValue(51, "padrão", "13/8");
		ds.addValue(51, "padrão", "13/9");
		ds.addValue(51, "padrão", "13/10");
		ds.addValue(51, "padrão", "13/11");
		ds.addValue(51, "padrão", "14");
		ds.addValue(51, "padrão", "14/1");
		ds.addValue(51, "padrão", "14/2");
		ds.addValue(51, "padrão", "14/3");
		ds.addValue(51, "padrão", "14/4");
		ds.addValue(51, "padrão", "14/5");
		ds.addValue(51, "você", "13/4");
		ds.addValue(47, "você", "13/5");
		ds.addValue(48, "eu", "14/1");
		ds.addValue(48, "eu", "14/2");
		
		
		Grafico chart = new Grafico(
	         "Gráfico" ,
	         "PESO X IDADE", "IDADE", "PESO", ds);

	      chart.pack( );
	      RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	   }

}
