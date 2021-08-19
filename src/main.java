/*
* @AUTHOR: S.ABILASH
* COMMENT: GOT SUPER BORED SO I THOUGHT WHY I DONT I CREATE A SIMPLE GAME
*
*/

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.lang.Math;
import java.util.Scanner;


public class main {
    static int playerState = 1;
    static int computer = 0;
    static int minAlloc = 0;
    static int maxAlloc = 9;
    static int[] user_selection = new int[5];
    static int[] robot_selection = new int[5];

    public static boolean checkWhoWonTheMatch(int result[])
    {
        if(!linear(result,1,2,3))
        {
            if(!linear(result,4,5,6))
            {
                if(!linear(result,7,8,9))
                {
                    if(!linear(result,1,4,7))
                    {
                        if(!linear(result,2,5,8))
                        {
                            if(!linear(result,3,6,9))
                            {
                                if(!linear(result,1,5,9))
                                {
                                    if(!linear(result,3,5,7))
                                    {
                                        return  false;
                                    }else{
                                        return true;
                                    }
                                }else{
                                    return true;
                                }
                            }else{
                                return true;
                            }
                        }else{
                            return true;
                        }
                    }else {
                        return true;
                    }
                }else {
                    return true;
                }
            }else{
                return true;
            }
        }else {
            return true;
        }
    }
    public static  void checkDraw()
    {
        boolean fullStackA = false;
        boolean fullStackB = false;
        for(int i:user_selection)
        {
            if(i==0){
                fullStackA = true;
                break;
            }
        }
        for(int i:robot_selection)
        {
            if(i==0){
                fullStackB = true;
                break;
            }
        }
        if(!(fullStackA && fullStackB))
        {
            gotWinner(3);
        }

    }

    public  static  boolean linear(int obtained[],int a, int b, int c)
    {
        boolean flagA=false;
        boolean flagB=false;
        boolean flagC=false;
        for(int i:obtained)
        {
            if(i==a)
            {
                flagA=true;
            }
            if(i==b)
            {
                flagB=true;
            }
            if(i==c)
            {
                flagC=true;
            }
        }
        if(flagA && flagB && flagC)
        {
            return true;
        }
        return false;
    }
    public static boolean check_exists(int user[], int robot[], int element) {
        for (int i : user) {
            if (i == element) {
                return true;
            }
        }
        for (int i : robot) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }
    public  static boolean botCheckExist(int value)
    {
        for(int i:user_selection)
        {
            if(i==value){
                return false;
            }
        }
        for(int i:robot_selection)
        {
            if(i==value){
                return false;
            }
        }
        return true;
    }

    public static  void callBot(JButton one,JButton two,JButton three,JButton four,JButton five,JButton six,JButton seven,JButton eight,JButton nine )
    {
        computer = (int)Math.round(Math.random()*(maxAlloc-minAlloc+1)+minAlloc);
        if(botCheckExist(computer))
        {
            switch (computer)
            {
                case 1:one.doClick();break;
                case 2:two.doClick();break;
                case 3:three.doClick();break;
                case 4:four.doClick();break;
                case 5:five.doClick();break;
                case 6:six.doClick();break;
                case 7:seven.doClick();break;
                case 8:eight.doClick();break;
                case 9:nine.doClick();break;
                default:callBot(one, two, three, four, five, six, seven, eight, nine);break;
            }
        }else{
            callBot(one, two, three, four, five, six, seven, eight, nine);
        }
    }

    public static void gotWinner(int userState)
    {

        JFrame winner = new JFrame("Tic Tac Toe Winner");
        {
            winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            winner.setSize(200,100);
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\assest\\icon.png");
            winner.setIconImage(icon);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - winner.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - winner.getHeight()) / 2);
            winner.setLocation(x, y);
            JPanel winnerPanel = new JPanel();
            if(userState==1)
            {
                JLabel winnerName = new JLabel("Congrats You Won The Match");
                JButton winnerButton = new JButton("Thank You");

                winnerPanel.add(winnerName);
                winnerPanel.add(winnerButton);

                winner.getContentPane().add(BorderLayout.CENTER,winnerPanel);
                winner.setVisible(true);
                winnerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        winner.dispose();

                    }
                });
                System.out.println("WON : USER");
            }else if(userState==0){
                JLabel winnerName = new JLabel("Computer Won The Match");
                JButton winnerButton = new JButton("OK");

                winnerPanel.add(winnerName);
                winnerPanel.add(winnerButton);

                winner.getContentPane().add(BorderLayout.CENTER,winnerPanel);
                winner.setVisible(true);
                winnerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        winner.dispose();

                    }
                });
                System.out.println("WON : COMPUTER");
            }else{
                JLabel winnerName = new JLabel("CRAP,IT IS A DRAW MATCH");
                JButton winnerButton = new JButton("OK");

                winnerPanel.add(winnerName);
                winnerPanel.add(winnerButton);

                winner.getContentPane().add(BorderLayout.CENTER,winnerPanel);
                winner.setVisible(true);
                winnerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        winner.dispose();

                    }
                });
                System.out.println("WON : DRAW");
            }
        }
    }
    public static void push(int a[], int element) {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==0){
                a[i]=element;
                break;
            }
        }
    }

    public static void changePLayerState() {
        if (playerState == 0) {
            playerState = 1;
        } else {
            playerState = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("TIC-TAC-TOE ~By: S.ABILASH ");
        System.out.println("CHOOSE OPTION:\n 1. SINGLE PLAYER MODE\n 2. TWO PLAYER MODE");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nENTER YOUR CHOICE: ");
        int choose = sc.nextInt();
        if(choose !=1 && choose !=2)
        {
            System.out.println("STUPID GIVE ME THE CORRECT NO ");
            System.exit(1);
        }
        JFrame window = new JFrame("Tic Tac Toe ~By: S.ABILASH");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 505);
        //set icon
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\assest\\icon.png");
        window.setIconImage(icon);
        //set the window at center
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - window.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - window.getHeight()) / 2);
        window.setLocation(x, y);
        //create a panel
        JPanel panel = new JPanel();

        //create nine button for tic tac toe

        JButton one = new JButton(new ImageIcon("src\\assest\\card.png"));
        one.setPreferredSize(new Dimension(150, 150));

        JButton two = new JButton(new ImageIcon("src\\assest\\card.png"));
        two.setPreferredSize(new Dimension(150, 150));

        JButton three = new JButton(new ImageIcon("src\\assest\\card.png"));
        three.setPreferredSize(new Dimension(150, 150));

        JButton four = new JButton(new ImageIcon("src\\assest\\card.png"));
        four.setPreferredSize(new Dimension(150, 150));

        JButton five = new JButton(new ImageIcon("src\\assest\\card.png"));
        five.setPreferredSize(new Dimension(150, 150));

        JButton six = new JButton(new ImageIcon("src\\assest\\card.png"));
        six.setPreferredSize(new Dimension(150, 150));

        JButton seven = new JButton(new ImageIcon("src\\assest\\card.png"));
        seven.setPreferredSize(new Dimension(150, 150));

        JButton eight = new JButton(new ImageIcon("src\\assest\\card.png"));
        eight.setPreferredSize(new Dimension(150, 150));

        JButton nine = new JButton(new ImageIcon("src\\assest\\card.png"));
        nine.setPreferredSize(new Dimension(150, 150));


        //add all the button to the panel

        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);


        window.getContentPane().add(BorderLayout.CENTER, panel);
        window.setVisible(true);
        //event listener
        one.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 1)) {
                            one.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 1);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);
                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 1)) {
                            one.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 1);
                            if(checkWhoWonTheMatch(robot_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                        }
                    }
                }
            });

            two.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 2)) {
                            two.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 2);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);

                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 2)) {
                            two.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 2);
                            if(checkWhoWonTheMatch(robot_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                        }
                    }
                }
            });

            three.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 3)) {
                            three.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 3);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);
                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 3)) {
                            three.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 3);
                            if(checkWhoWonTheMatch(robot_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                        }
                    }
                }
            });

            four.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 4)) {
                            four.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 4);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);

                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 4)) {
                            four.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 4);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                        }
                    }
                }
            });

            five.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 5)) {
                            five.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 5);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);

                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 5)) {
                            five.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 5);
                            if(checkWhoWonTheMatch(robot_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                        }
                    }
                }
            });

            six.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 6)) {
                            six.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 6);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);

                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 6)) {
                            six.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 6);
                            if(checkWhoWonTheMatch(robot_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                        }
                    }
                }
            });

            seven.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 7)) {
                            seven.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 7);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);

                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 7)) {
                            seven.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 7);
                            if(checkWhoWonTheMatch(robot_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                        }
                    }
                }
            });

            eight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 8)) {
                            eight.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 8);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);

                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 8)) {
                            eight.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 8);
                            if(checkWhoWonTheMatch(robot_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                        }
                    }
                }
            });

            nine.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (playerState == 1) {
                        if (!check_exists(user_selection, robot_selection, 9)) {
                            nine.setIcon(new ImageIcon("src\\assest\\x_player.png"));
                            push(user_selection, 9);
                            if(checkWhoWonTheMatch(user_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();
                            if(choose==1)
                                callBot(one,two,three,four,five,six,seven,eight,nine);

                        }
                    } else if (playerState == 0) {
                        if (!check_exists(user_selection, robot_selection, 9)) {
                            nine.setIcon(new ImageIcon("src\\assest\\o_player.png"));
                            push(robot_selection, 9);
                            if(checkWhoWonTheMatch(robot_selection))
                            {
                                gotWinner(playerState);
                            }
                            checkDraw();
                            changePLayerState();

                        }
                    }
                }
            });

    }
}
