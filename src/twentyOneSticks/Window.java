package twentyOneSticks;

	import java.awt.BorderLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.WindowEvent;
	import java.awt.event.WindowListener;
	import java.util.concurrent.CountDownLatch;

	import javax.swing.*;

	public class Window extends JFrame implements WindowListener
	{
	    public Window(){this(30, 50);}
	    public Window(int rows, int columns){this(rows, columns, true);}
	    public Window(int rows, int columns, boolean exitOnClose)
	    {
	        this.exitOnClose = exitOnClose;
	        latch = new CountDownLatch(1);
	        panel = new JPanel();
	        panel.setLayout(new BorderLayout());
	        field = new JTextField(columns);
	        field.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                entered = field.getText();
	                field.setText("");
	                latch.countDown();
	            }
	        });
	        area = new JTextArea(rows, columns);
	        area.setWrapStyleWord(true);
	        area.setLineWrap(true);
	        area.setEditable(false);
	        pane = new JScrollPane(area);
	        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        
	        JPanel southLayout = new JPanel();
	        southLayout.add(field);
	        panel.add(southLayout, BorderLayout.SOUTH);
	        
	        JPanel centerLayout = new JPanel();
	        centerLayout.add(pane);
	        panel.add(centerLayout, BorderLayout.CENTER);
	        
	        this.addWindowListener(this);
	        
	        this.getContentPane().add(panel);
	        this.pack();
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);

	        field.requestFocus();
	    }
	    
	    @Override public void windowActivated(WindowEvent e) {}
	    @Override public void windowClosed(WindowEvent e){}
	    @Override public void windowDeactivated(WindowEvent e){}
	    @Override public void windowDeiconified(WindowEvent e) {}
	    @Override public void windowIconified(WindowEvent e){}
	    @Override public void windowOpened(WindowEvent e){}
	    
	    @Override
	    public void windowClosing(WindowEvent e) 
	    {
	        if(exitOnClose) System.exit(0);
	    }

	    public void print(final String s)
	    {
	        Runnable run = new Runnable()
	        {
	            public void run()
	            {
	                area.append(s);
	                area.repaint();
	            }
	        };
	        
	        SwingUtilities.invokeLater(run);
	    }

	    public void println(final String s)
	    {
	        Runnable run = new Runnable()
	        {
	            public void run()
	            {
	                area.append(s + "\n");
	                area.repaint();
	            }
	        };
	        
	        SwingUtilities.invokeLater(run);
	    }


	    public String nextLine()
	    {
	        try 
	        {
	            latch.await();
	            resetLatch();
	            return entered.trim();
	        } catch (InterruptedException e) 
	        {
	            System.out.println("Error occurred: " + e.toString());
	            e.printStackTrace();
	        }
	        
	        return null;
	    }
	    
	    public int nextInt()
	    {
	        return Integer.valueOf(nextLine());
	    }
	    
	    public long nextLong()
	    {
	        return Long.valueOf(nextLine());
	    }
	    
	    public float nextFloat()
	    {
	        return Float.valueOf(nextLine());
	    }
	    
	    public double nextDouble()
	    {
	        return Double.valueOf(nextLine());
	    }
	    
	    public short nextShort()
	    {
	        return Short.valueOf(nextLine());
	    }
	    
	    public boolean prompt()
	    {
	        return nextLine().toLowerCase().startsWith("y");
	    }
	    
	    public void resetLatch()
	    {
	        latch = new CountDownLatch(1);
	    }
	    
	    private boolean exitOnClose;
	    private JPanel panel;
	    private JTextArea area;
	    private JScrollPane pane;
	    private JTextField field;
	    private String entered;
	    private CountDownLatch latch;
	}

