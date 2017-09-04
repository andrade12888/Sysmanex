package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;


public class Reportes extends JFrame {
   
   public Reportes( String title, ResultSet rs, String opc ) {
      super( title ); 
      setContentPane(createDemoPanel(rs, opc));
   }
   
   private static PieDataset createDataset(ResultSet rs, String opc ) {
       
       try {
           DefaultPieDataset dataset = new DefaultPieDataset( );
           
           switch(opc)
           {
               case "ExpVencidos":
                   while(rs!=null && rs.next())
                   {
                       dataset.setValue( rs.getString("Fecha De Envio") , new Double( rs.getInt("Cantidad de Expedientes Vencidos") ) );                       
                   }
                   break;
           }
           return dataset;
       } catch (SQLException ex) {
           return null;
       }
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Expedientes abiertos por mes",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel(ResultSet rs, String opc ) {
      JFreeChart chart = createChart(createDataset(rs , opc) ); 
      return new ChartPanel( chart ); 
   }

   public static void BuildReport(String nombreReporte, ResultSet rs, String opc) {
      Reportes demo = new Reportes( nombreReporte, rs,opc );        
      demo.setSize( 800 , 600 );    
      RefineryUtilities.centerFrameOnScreen( demo );
      demo.setVisible(true);       
      demo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
   
   public Reportes( String applicationTitle , String chartTitle ,ResultSet rs, String opc) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "","Expedientes vencidos", //Horizontal line - Vertical Line
         createDatasetXY(rs,opc),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 800 , 600 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDatasetXY( ResultSet rs, String opc) {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
    try {                     
           switch(opc)
           {
               case "ExpVencidos":
                   while(rs!=null && rs.next())
                   {
                    dataset.addValue( rs.getInt("Cantidad de Expedientes Vencidos"),"Expedientes Vencidos",rs.getString("Fecha De Envio") );                       
                   }
                   break;
           }

       } catch (SQLException ex) {
           return null;
       }
      return dataset;
   }
   
   public static void LineChart(ResultSet rs, String opc) {
      Reportes chart = new Reportes(
         "Cantidad de Expedientes" ,
         "",rs,opc);

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
      chart.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
   
   
}
    
