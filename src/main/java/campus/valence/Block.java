package campus.valence;

import javax.swing.*;
import java.awt.*;

public class Block {
    private JPanel panel;

    public Block(int i, int nbOfBlock) {
        this.panel = new JPanel();
        int width = 50;
        int widthFrame = 400;
        int widthGap = widthFrame - width * nbOfBlock;
        int gap = (int) widthGap / nbOfBlock;

        this.panel.setBounds((gap/2)*(i+1)+width*i, 5, width, 30);

//        if(i==0){
//            this.panel.setBounds((gap)*(i+1), 5, width, 30);
//        }else{
//            this.panel.setBounds(gap*(i+1)+width*i, 5, width, 30);
//        }
        this.panel.setBackground(Color.BLUE);

    }

    public JPanel getPanel() {
        return panel;
    }
}
