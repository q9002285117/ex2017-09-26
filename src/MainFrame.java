import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private Button btnadd=new Button("add");
    private Label lab=new Label(">0<");
    int count=0;
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,500,300);
        this.setLayout(null);
        btnadd.setBounds(150,150,100,30);
        this.add(btnadd);
        lab.setBounds(150,160,100,60);
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

                MainFrame.this.setTitle(Integer.toString(++count));
                lab.setText(Integer.toString(count));
            }
        });

    }
}
