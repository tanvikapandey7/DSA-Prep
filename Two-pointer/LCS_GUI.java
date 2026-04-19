import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class LCS_GUI extends JFrame {

    JTextField inputX, inputY;
    JTable table1, table2;
    JLabel resultLabel;

    public LCS_GUI() {

        setTitle("Longest Common Subsequence Visualizer");
        setSize(1100, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🔹 HEADER
        JLabel header = new JLabel("Longest Common Subsequence Visualizer", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setOpaque(true);
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setBorder(new EmptyBorder(10,10,10,10));
        add(header, BorderLayout.NORTH);

        // 🔹 TABLE PANEL
        JPanel tablePanel = new JPanel(new GridLayout(1,2,20,0));
        tablePanel.setBorder(new EmptyBorder(20,20,20,20));

        // 📊 TABLE 1 PANEL
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(new LineBorder(new Color(70,130,180), 3)); // BLUE BORDER

        JLabel t1Label = new JLabel("Length Matrix", SwingConstants.CENTER);
        t1Label.setFont(new Font("Arial", Font.BOLD, 16));
        t1Label.setOpaque(true);
        t1Label.setBackground(new Color(100,149,237));
        t1Label.setForeground(Color.WHITE);

        table1 = new JTable();
        leftPanel.add(t1Label, BorderLayout.NORTH);
        leftPanel.add(new JScrollPane(table1), BorderLayout.CENTER);

        // 📊 TABLE 2 PANEL
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(new LineBorder(new Color(34,139,34), 3)); // GREEN BORDER

        JLabel t2Label = new JLabel("Directional Path", SwingConstants.CENTER);
        t2Label.setFont(new Font("Arial", Font.BOLD, 16));
        t2Label.setOpaque(true);
        t2Label.setBackground(new Color(60,179,113));
        t2Label.setForeground(Color.WHITE);

        table2 = new JTable();
        rightPanel.add(t2Label, BorderLayout.NORTH);
        rightPanel.add(new JScrollPane(table2), BorderLayout.CENTER);

        tablePanel.add(leftPanel);
        tablePanel.add(rightPanel);

        add(tablePanel, BorderLayout.CENTER);

        // 🔹 RESULT PANEL (BOTTOM ✅)
       // 🔹 BOTTOM CONTAINER (Result + Input)
JPanel bottomContainer = new JPanel();
bottomContainer.setLayout(new BorderLayout());

// RESULT PANEL (TOP of bottom container)
JPanel resultPanel = new JPanel();
resultPanel.setBorder(new LineBorder(new Color(34,139,34), 3));
resultPanel.setBackground(new Color(240,255,240));

resultLabel = new JLabel("Longest Common Subsequence (LCS): ", SwingConstants.CENTER);
resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

resultPanel.add(resultLabel);

// INPUT PANEL (BOTTOM)
JPanel inputPanel = new JPanel();

inputPanel.add(new JLabel("String X:"));
inputX = new JTextField(10);
inputPanel.add(inputX);

inputPanel.add(new JLabel("String Y:"));
inputY = new JTextField(10);
inputPanel.add(inputY);

JButton startBtn = new JButton("Start Animation");
inputPanel.add(startBtn);

// ADD BOTH
bottomContainer.add(resultPanel, BorderLayout.NORTH);
bottomContainer.add(inputPanel, BorderLayout.SOUTH);

// ADD TO FRAME
add(bottomContainer, BorderLayout.SOUTH);

// BUTTON ACTION
startBtn.addActionListener(e -> runLCS());

        setVisible(true);
    }
    void runLCS() {

        String X = inputX.getText();
        String Y = inputY.getText();

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m+1][n+1];
        String[][] path = new String[m+1][n+1];

        String[] cols = new String[n+1];
        cols[0] = "";
        for(int j=1;j<=n;j++) cols[j] = Y.charAt(j-1)+"";

        DefaultTableModel model1 = new DefaultTableModel(cols,0);
        DefaultTableModel model2 = new DefaultTableModel(cols,0);

        for(int i=0;i<=m;i++){
            Object[] row1 = new Object[n+1];
            Object[] row2 = new Object[n+1];

            row1[0] = (i==0) ? "" : X.charAt(i-1);
            row2[0] = (i==0) ? "" : X.charAt(i-1);

            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                    path[i][j]="";
                }
                else if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    path[i][j]="↖";
                }
                else if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j]=dp[i-1][j];
                    path[i][j]="↑";
                }
                else{
                    dp[i][j]=dp[i][j-1];
                    path[i][j]="←";
                }

                row1[j]=dp[i][j];
                row2[j]=path[i][j];
            }

            model1.addRow(row1);
            model2.addRow(row2);
        }

        table1.setModel(model1);
        table2.setModel(model2);

        // 🔹 BACKTRACK
        StringBuilder lcs = new StringBuilder();
        int i=m, j=n;

        while(i>0 && j>0){
            if(X.charAt(i-1)==Y.charAt(j-1)){
                lcs.append(X.charAt(i-1));
                i--; j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            } else j--;
        }

        resultLabel.setText("Longest Common Subsequence (LCS): " + lcs.reverse());
    }

    public static void main(String[] args) {
        new LCS_GUI();
    }
}