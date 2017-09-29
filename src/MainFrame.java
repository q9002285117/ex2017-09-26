import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private Button btnadd=new Button("add");
    private Button btnsub=new Button("sub");
    private Button btnexit=new Button("exit");
    private Button btnmove=new Button("move");
    private Label lab=new Label(">0<");
    private boolean bl=true;
    private int count=0,labX=150,labY=100;
    private Timer t1;

    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,600,400);
        this.setLayout(null);
        btnadd.setBounds(150,150,100,30);
        btnsub.setBounds(270,150,100,30);
        btnexit.setBounds(390,150,100,30);
        btnmove.setBounds(20,150,100,30);
        this.add(btnadd);
        this.add(btnsub);
        this.add(btnexit);
        this.add(btnmove);
        lab.setBounds(labX,labY,30,30);
        lab.setBackground(Color.PINK);
        this.add(lab);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                t1.start();
                MainFrame.this.setTitle(Integer.toString(++count));
                lab.setText(Integer.toString(count));
            }
        });
        btnsub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setTitle(Integer.toString(--count));
                lab.setText(Integer.toString(count));
            }
        });
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnmove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
            }
        });
        t1=new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bl==false) {
                    labX -= 5;
                    lab.setLocation(labX, labY);
                    if(labX==10)
                        bl=true;
                }
                if (bl == true) {
                        labX += 5;
                        lab.setLocation(labX, labY);
                    if(labX==570){
                        bl=false;
                    }
                }
            }
        });

    }
}
