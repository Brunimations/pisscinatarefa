package piscinas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Piscinas extends JFrame{
    
    private JTextField tfprofund;
    private JTextField tfcomp;
    private JTextField tflarg;
    private JTextField tfvol;
    private JTextField tfpre;
    
    private JLabel lblprofund;
    private JLabel lblcomp;
    private JLabel lbllarg;
    private JLabel lblvol;
    private JLabel lblpre;
    private JLabel lblaviso;
    
    private JButton btncalcular;
    private JButton btnlimpar;
    
    private static Piscinas frame;
    
    public Piscinas(){
        iniciateComponents();
        defineEvent();
    }
    
    private void iniciateComponents(){
        setTitle ("Calculo de preço");
        setBounds(0,0,900,700);
        setLayout(null);
        
        tfprofund=new JTextField(5);
        tfcomp=new JTextField (5);
        tflarg=new JTextField (5);
        tfvol=new JTextField (5);
        tfpre=new JTextField (5);
        
        lblprofund=new JLabel ("Profundidade");
        lblcomp=new JLabel ("Comprimento");
        lbllarg=new JLabel ("Largura");
        lblvol=new JLabel ("Volume");
        lblpre=new JLabel ("Valor");
        lblaviso=new JLabel ("(Coloque as medidas em metros)");
        
        btncalcular=new JButton ("Calcular");
        btnlimpar=new JButton ("Limpar");
        
        
        tfprofund.setBounds(450,100,450,100);
        tfcomp.setBounds(450,200,450,100);
        tflarg.setBounds(450,300,450,100);
        tfvol.setBounds (450,500,450,100);
        tfpre.setBounds(450,600,450,100);
        
        lblaviso.setBounds (0,0,450,100);
        lblprofund.setBounds(0,100,450,100);
        lblcomp.setBounds(0,200,450,100);
        lbllarg.setBounds(0,300,450,100);
        lblvol.setBounds (0,500,450,100);
        lblpre.setBounds (0,600,450,100);
        
        
        btncalcular.setBounds (450,400,450,100);
        btnlimpar.setBounds (0,400,450,100);
        
        add(tfprofund);
        add(tfcomp);
        add(tflarg);
        add(tfvol);
        add(tfpre);
        add(lblpre);
        add(lblprofund);
        add(lblcomp);
        add(lbllarg);
        add(lblvol);
        add(lblpre);
        add(lblaviso);
        add(btncalcular);
        add(btnlimpar);
    }
    
    double vol=0,val=0,profund=0,larg=0,comp=0;
    
    private void defineEvent(){
        btncalcular.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try{
            profund=Double.parseDouble(tfprofund.getText());
            larg=Double.parseDouble(tflarg.getText());
            comp=Double.parseDouble(tfcomp.getText());
            
            vol=profund*comp*larg;
            val=vol*300;
            tfvol.setText(""+vol);
            tfpre.setText(""+val);
            
        }
        catch(NumberFormatException erro){
            tfvol.setText("Erro de digitação");
            
            
        }
        
        }
        });
        btnlimpar.addActionListener (new ActionListener()
{
                public void actionPerformed (ActionEvent e)
                {
                tfcomp.setText("");
                tflarg.setText("");
                tfvol.setText("");
                tfpre.setText("");
                tfprofund.setText("");
                }
            });
        }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                frame = new Piscinas();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela=Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((tela.width - frame.getSize().width)/2, (tela.height - frame.getSize().height)/2);
                frame.setVisible(true);
            }
        });    
       }
    }
   
