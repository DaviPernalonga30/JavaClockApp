/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclockapp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author davip
 */
public class ClockFrame extends JFrame{
    
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dateLabel;
    String time;
    String date;
    
    ClockFrame(){                                                               //Construtor do objeto ClockFrame   
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                    //permite fechar a aba
        this.setTitle("Clock");                                                 //Nome da aba é clock
        //this.setLayout(new FlowLayout());                                       //Layout para centralizar
        this.setSize(350, 200);                                                 //Tamanho da aba
        this.setResizable(false);                                                //Deixar a aba mudar de tamanho
        
        //Fomats.
        
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        timeFormat = new SimpleDateFormat("hh:mm:ss");                          //Criação do formatador de horário
        
        //TimeLabels.
        
        timeLabel = new JLabel();                                               //Colocando a hora em uma camada da GUI
        timeLabel.setForeground(Color.green);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        
        //Box layouts são a solução nesse caso.
        
        
        timeLabel.setHorizontalAlignment(this.getX()/2);
        timeLabel.setVerticalAlignment(this.getY()/2);
        
        //Date Labels
        
        dateLabel = new JLabel();
        
        //dateLabel.setHorizontalAlignment((this.getX()/2) + 30);
        //dateLabel.setVerticalAlignment((this.getY()/2) + 30);
        
        
        
        
        this.add(timeLabel);                                                    //Adicionando a camada
        //this.add(dateLabel);
        
        
        
        
        this.setVisible(true);                                                  //Deixar a aba visivel
        
        RefreshTime();
        
 
    }
    
    
    
    public void RefreshTime() {
        while(true)
        {
        time = timeFormat.format(Calendar.getInstance().getTime());             //Pegando a hora
        timeLabel.setText(time);                                                //Adicionando a hora em uma camada
        
        date = dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText(date);
        
        
            try 
            {
                Thread.sleep(1000);
            } catch (InterruptedException ex) 
            {
                Logger.getLogger(ClockFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }    
    
}
