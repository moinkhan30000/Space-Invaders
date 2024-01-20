import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
public class FinalShop extends JPanel {
    private Image image = new ImageIcon("Shop.jpg").getImage();
    static int tCurrency;
    static int tShipLevel ;
    static int tPrimaryWeapon1Level;
    static int tPrimaryWeapon2Level;
    static int tSecondaryWeapon1Level;
    static int tSecondaryWeapon2Level;
    static int ability1Count;
    static int ability2Count;
    static int ability3Count;
    static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    
    public void setShipLevel(int x)
    {
        tShipLevel = x;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), 0, 0, image.getWidth(null), image.getHeight(null), null);
        
    }
    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = new int[9];
        int i = 0 ;
        Scanner input = new Scanner(new File("Tools.txt"));
        while(input.hasNextLine())
        {
            String x = input.nextLine();
            x = x.substring(x.indexOf("-")+1);
            arr[i] = Integer.parseInt(x);
            i++;


        }
        tCurrency = arr[0];
        tShipLevel = arr[1];
        tPrimaryWeapon1Level = arr[2];
        tPrimaryWeapon2Level = arr[3];
        tSecondaryWeapon1Level = arr[4];
        tSecondaryWeapon2Level = arr[5];
        ability1Count = arr[6];
        ability2Count = arr[7];
        ability3Count = arr[8];
        FinalShop z = new FinalShop();
        //z.setSize(1707,1200);
        //JFrame y = new JFrame("Shop");
        JWindow y = new JWindow();
        Dimension d = new DimensionUIResource(100, 100);
        Dimension backbutton = new DimensionUIResource(150, 100);
        Image temp = new ImageIcon("Upgrade.png").getImage();
        temp = temp.getScaledInstance((int)d.getWidth(),(int)d.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon Bicon = new ImageIcon(temp);
        temp = new ImageIcon("Ship.png").getImage();
        temp = temp.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon= new ImageIcon(temp);
        temp = new ImageIcon("Primary1.png").getImage();
        temp = temp.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon2= new ImageIcon(temp);
        temp = new ImageIcon("Primary2.png").getImage();
        temp = temp.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon3 = new ImageIcon(temp);
        temp = new ImageIcon("Secondary Weapon 1.png").getImage();
        temp = temp.getScaledInstance(200,100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon4 = new ImageIcon(temp);
        temp = new ImageIcon("Secondary 2.png").getImage();
        temp = temp.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon5 = new ImageIcon(temp);
        temp = new ImageIcon("Currency.png").getImage();
        temp = temp.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon6 = new ImageIcon(temp);
        temp = new ImageIcon("Back.png").getImage();
        temp = temp.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon7 = new ImageIcon(temp);
        temp = new ImageIcon("Health2.png").getImage();
        temp = temp.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon8 = new ImageIcon(temp);
        temp = new ImageIcon("Adrenaline.png").getImage();
        temp = temp.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon9 = new ImageIcon(temp);
        temp = new ImageIcon("Invincible.png").getImage();
        temp = temp.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon10 = new ImageIcon(temp);
        Border border = BorderFactory.createEmptyBorder();
        JButton b1 = new JButton(Bicon);
        b1.setOpaque(false);
        b1.setBackground(Color.yellow);
        b1.setPreferredSize(d);
        b1.setBorder(border);
        JButton b2 = new JButton(Bicon);
        b2.setOpaque(false);
        b2.setBackground(Color.yellow);
        b2.setPreferredSize(d);
        b2.setBorder(border);
        JButton b3 = new JButton(Bicon);
        b3.setOpaque(false);
        b3.setBackground(Color.yellow);
        b3.setPreferredSize(d);
        b3.setBorder(border);
        JButton b4 = new JButton(Bicon);
        b4.setOpaque(false);
        b4.setBackground(Color.yellow);
        b4.setPreferredSize(d);
        b4.setBorder(border);
        JButton b5 = new JButton(Bicon);
        b5.setOpaque(false);
        b5.setBackground(Color.yellow);
        b5.setPreferredSize(d);
        b5.setBorder(border);
        JButton b6 = new JButton(icon7);
        b6.setText("Back");
        b6.setForeground(Color.CYAN);
        b6.setFont(new Font("Serif",Font.BOLD,20));
        b6.setOpaque(false);
        b6.setBackground(Color.yellow);
        b6.setPreferredSize(backbutton);
        b6.setBorder(border);
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String[] tempeStrings = new String[9];
                tempeStrings[0] = "Currency-" + tCurrency;
                tempeStrings[1] = "ShipLevel-" + tShipLevel;
                tempeStrings[2] = "PrimaryWeapon1-" + tPrimaryWeapon1Level;
                tempeStrings[3] = "PrimaryWeapon2-" + tPrimaryWeapon2Level;
                tempeStrings[4] = "SecondaryWeapon1-" + tSecondaryWeapon1Level;
                tempeStrings[5] = "SecondaryWeapon2-" + tSecondaryWeapon2Level;
                tempeStrings[6] = "Ability1Count-" + ability1Count;
                tempeStrings[7] = "Ability2Count-" + ability2Count;
                tempeStrings[8] = "Ability3Count-" + ability3Count;
                try {
                    FileWriter fWriter = new FileWriter("Tools.txt",false);
                    for(int j = 0; j<9; j++)
                    {
                        fWriter.write(tempeStrings[j] + "\n");
                    }
                    fWriter.close();;
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });
        JButton b7 = new JButton(Bicon);
        b7.setOpaque(false);
        b7.setBackground(Color.yellow);
        b7.setPreferredSize(d);
        b7.setBorder(border);
        JButton b8 = new JButton(Bicon);
        b8.setOpaque(false);
        b8.setBackground(Color.yellow);
        b8.setPreferredSize(d);
        b8.setBorder(border);
        JButton b9 = new JButton(Bicon);
        b9.setOpaque(false);
        b9.setBackground(Color.yellow);
        b9.setPreferredSize(d);
        b9.setBorder(border);
        JLabel label  = new JLabel(icon);
        label.setForeground(Color.CYAN);
        label.setFont(new Font("Serif",Font.BOLD,20));
        if(tShipLevel<3)
        {
            label.setText("   Level of Ship :  " + tShipLevel);
        }
        else
        {
            label.setText("   Level of Ship Max");
        }
        JLabel label2 = new JLabel(icon2);
        label2.setForeground(Color.CYAN);
        label2.setFont(new Font("Serif",Font.BOLD,20));
        if(tPrimaryWeapon1Level<3)
        {
            label2.setText("Level of Primary Weapon 1 :  " + tPrimaryWeapon1Level);
        }
        else
        {
            label2.setText("Level of Primary Weapon 1 is Max");
        }
        JLabel label3 = new JLabel(icon3);
        label3.setForeground(Color.CYAN);
        label3.setFont(new Font("Serif",Font.BOLD,20));
        if(tPrimaryWeapon2Level<3)
        {
            label3.setText("Level of Primary Weapon 2 :  " + tPrimaryWeapon2Level);
        }
        else
        {
            label3.setText("Level of Primary Weapon 2 is Max");
        }
        JLabel label4 = new JLabel(icon4);
        label4.setForeground(Color.CYAN);
        label4.setFont(new Font("Serif",Font.BOLD,20));
        if(tSecondaryWeapon1Level<3)
        {
            label4.setText("Level of Secondary Weapon 1 :  " + tSecondaryWeapon1Level);
        }
        else
        {
            label4.setText("Level of Secondary Weapon 1 is Max");
        }
        JLabel label5 = new JLabel(icon5);
        label5.setForeground(Color.CYAN);
        label5.setFont(new Font("Serif",Font.BOLD,20));
        if(tSecondaryWeapon2Level<3)
        {
            label5.setText("Level of Secondary Weapon 2 :  " + tSecondaryWeapon1Level);
        }
        else
        {
            label5.setText("Level of Secondary Weapon 2 is Max");
        }
        JLabel label6 = new JLabel(icon6);
        label6.setForeground(Color.GREEN);
        label6.setFont(new Font("Serif",Font.BOLD,20));
        label6.setText("Currency : " + tCurrency);
        JLabel label7 = new JLabel(icon8);
        label7.setForeground(Color.CYAN);
        label7.setFont(new Font("Serif",Font.BOLD,20));
        label7.setText("Regeneration Ability : " + ability1Count);
        JLabel label8 = new JLabel(icon9);
        label8.setForeground(Color.CYAN);
        label8.setFont(new Font("Serif",Font.BOLD,20));
        label8.setText("Adrenaline Ability : " + ability2Count);
        JLabel label9 = new JLabel(icon10);
        label9.setForeground(Color.CYAN);
        label9.setFont(new Font("Serif",Font.BOLD,20));
        label9.setText("Invincibility Ability : " + ability3Count);


        class upgradeShip implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(tShipLevel == 1)
                {
                    if(tCurrency >= 500)
                    {
                        tShipLevel++;
                        tCurrency = tCurrency -500;
                        label.setText("   Level of Ship :  " + tShipLevel);
                        label6.setText("Currency : " + tCurrency);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else if(tShipLevel == 2)
                {
                    if(tCurrency >= 1000)
                    {
                        tShipLevel++;
                        tCurrency = tCurrency -1000;
                        label.setText("   Level of Ship Max");
                        label6.setText("Currency : " + tCurrency);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else
                {
                    label.setText("   Level of Ship Max");
                }
            }
            
        }
        class upgradePrimaryWeapon1 implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(tPrimaryWeapon1Level == 1)
                {
                    if(tCurrency >= 300)
                    {
                        tPrimaryWeapon1Level++;
                        tCurrency = tCurrency -300;
                        label2.setText("Level of Primary Weapon 1 :  " + tPrimaryWeapon1Level);
                        label6.setText("Currency : " + tCurrency);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else if(tPrimaryWeapon1Level == 2)
                {
                    if(tCurrency >= 700)
                    {
                        tPrimaryWeapon1Level++;
                        tCurrency = tCurrency -700;
                        label6.setText("Currency : " + tCurrency);
                        label2.setText("Level of Primary Weapon 1 is Max");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else
                {
                    label2.setText("Level of Primary Weapon 1 is Max");
                }
            }
            
        }
        class upgradePrimaryWeapon2 implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(tPrimaryWeapon2Level == 1)
                {
                    if(tCurrency >= 300)
                    {
                        tPrimaryWeapon2Level++;
                        tCurrency = tCurrency -300;
                        label6.setText("Currency : " + tCurrency);
                        label3.setText("Level of Primary Weapon 2 :  " + tPrimaryWeapon2Level);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else if(tPrimaryWeapon2Level == 2)
                {
                    if(tCurrency >= 700)
                    {
                        tPrimaryWeapon2Level++;
                        tCurrency = tCurrency -700;
                        label6.setText("Currency : " + tCurrency);
                        label3.setText("Level of Primary Weapon 2 is Max");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else
                {
                    label3.setText("Level of Primary Weapon 2 is Max");
                }
            }
            
        }
        class upgradeSecondaryWeapon1 implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(tSecondaryWeapon1Level == 1)
                {
                    if(tCurrency >= 400)
                    {
                        tSecondaryWeapon1Level++;
                        tCurrency = tCurrency - 400;
                        label6.setText("Currency : " + tCurrency);
                        label4.setText("Level of Secondary Weapon 1 :  " + tSecondaryWeapon1Level);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else if(tSecondaryWeapon1Level == 2)
                {
                    if(tCurrency >= 800)
                    {
                        tSecondaryWeapon1Level++;
                        tCurrency = tCurrency -800;
                        label6.setText("Currency : " + tCurrency);
                        label4.setText("Level of Secondary Weapon 1 is Max");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else
                {
                    label4.setText("Level of Secondary Weapon 1 is Max");
                }
            }
            
        }
        class upgradeSecondaryWeapon2 implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(tSecondaryWeapon2Level == 1)
                {
                    if(tCurrency >= 400)
                    {
                        tSecondaryWeapon2Level++;
                        tCurrency = tCurrency -400;
                        label6.setText("Currency : " + tCurrency);
                        label5.setText("Level of Secondary Weapon 2 :  " + tSecondaryWeapon1Level);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else if(tSecondaryWeapon2Level == 2)
                {
                    if(tCurrency >= 800)
                    {
                        tSecondaryWeapon2Level++;
                        tCurrency = tCurrency -800;
                        label6.setText("Currency : " + tCurrency);
                        label5.setText("Level of Secondary Weapon 2 is Max");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                        y.setVisible(true);
                    }
                }
                else
                {
                    label5.setText("Level of Secondary Weapon 2 is Max");
                }
            }
            
        }
        class increaseHealCount implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(tCurrency >500 && ability1Count<5)
                {
                    ability1Count++;
                    tCurrency = tCurrency - 500;
                    label7.setText("Regeneration Ability : " + ability1Count);
                    label6.setText("Currency : " + tCurrency);
                }
                else if(ability1Count>=5)
                {
                    JOptionPane.showMessageDialog(y,"You can only buy 5 of this ability");
                    y.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                    y.setVisible(true);
                }

            }
            
        }
        class increaseAdrenalineCount implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(tCurrency >600 && ability2Count<5)
                {
                    ability2Count++;
                    tCurrency = tCurrency - 600;
                    label8.setText("Adrenaline Ability : " + ability2Count);
                    label6.setText("Currency : " + tCurrency);
                }
                else if(ability2Count>=5)
                {
                    JOptionPane.showMessageDialog(y,"You can only buy 5 of this ability");
                    y.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                    y.setVisible(true);
                }

            }
            
        }
        class increaseInvincibilityCount implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(tCurrency >800 && ability3Count<5)
                {
                    ability3Count++;
                    tCurrency = tCurrency - 800;
                    label9.setText("Invincibility Ability : " + ability3Count);
                    label6.setText("Currency : " + tCurrency);
                }
                else if(ability3Count>=5)
                {
                    JOptionPane.showMessageDialog(y,"You can only buy 5 of this ability");
                    y.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(y,"You have Insufficient Currency");
                    y.setVisible(true);
                }

            }
            
        }
        z.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,0,800,1140);
        c.gridx = 0;
        c.gridy =0;
        c.gridheight = 1;
        c.gridwidth = 1;
        z.add(label,c);
        c.insets = new Insets(10,500,800,1000);
        z.add(b1,c);
        upgradeShip action = new upgradeShip();
        b1.addActionListener(action);
        c.insets = new Insets(10,0,400,1025);
        z.add(label2,c);
        c.insets = new Insets(10,500,400,1000);
        z.add(b2,c);
        upgradePrimaryWeapon1 action2 = new upgradePrimaryWeapon1();
        b2.addActionListener(action2);
        c.insets = new Insets(10,0,0,1025);
        z.add(label3,c);
        c.insets = new Insets(10,500,0,1000);
        z.add(b3,c);
        upgradePrimaryWeapon2 action3 = new upgradePrimaryWeapon2();
        b3.addActionListener(action3);
        c.insets = new Insets(10,0,-400,1010);
        z.add(label4,c);
        c.insets = new Insets(10,500,-400,1000);
        z.add(b4,c);
        upgradeSecondaryWeapon1 action4 = new upgradeSecondaryWeapon1();
        b4.addActionListener(action4);
        c.insets = new Insets(10,0,-800,1010);
        z.add(label5,c);
        c.insets = new Insets(10,500,-800,1000);
        z.add(b5,c);
        upgradeSecondaryWeapon2 action5 = new upgradeSecondaryWeapon2();
        b5.addActionListener(action5);
        c.insets = new Insets(10,1350,-800,0);
        z.add(label6,c);
        c.insets = new Insets(10,0,900,1550);
        z.add(b6,c);   
        c.insets = new Insets(10,670,800,0);
        z.add(label7,c);
        c.insets = new Insets(10,1200,800,0);
        increaseHealCount action6 = new increaseHealCount();
        b7.addActionListener(action6);
        z.add(b7,c);   
        c.insets = new Insets(10,650,400,0);
        z.add(label8,c);
        c.insets = new Insets(10,1200,400,0);
        increaseAdrenalineCount action7 = new increaseAdrenalineCount();
        b8.addActionListener(action7);
        z.add(b8,c);
        c.insets = new Insets(10,650,0,0); 
        z.add(label9,c);
        c.insets = new Insets(10,1200,0,0);
        increaseInvincibilityCount action8 = new increaseInvincibilityCount();
        b9.addActionListener(action8);
        z.add(b9,c); 
        y.setContentPane(z);
        y.setPreferredSize(size);
        System.out.println(size);
        y.setVisible(true);
        y.pack();

    }
}
