/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.applet.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPopupMenu;

/**
 *
 * @author federico F
 */
public class Coursework extends Applet {

    StatusCanvas HouseCanvas = new StatusCanvas("House", Color.yellow);
    StatusCanvas GateCanvas = new StatusCanvas("Gate", Color.green);
    StatusCanvas MartinCourtyardCanvas = new StatusCanvas("MartinCourtyard", Color.green);
    StatusCanvas RoadCanvas = new StatusCanvas("Road", Color.red);
    StatusCanvas ExitCanvas = new StatusCanvas("Exit", Color.green);
    StatusCanvas RoadSensorCanvas = new StatusCanvas("RoadSensor", Color.yellow);
    StatusCanvas MainSensorCanvas = new StatusCanvas("MainSensor", Color.yellow);
    StatusCanvas HouseSensorCanvas = new StatusCanvas("HouseSensor", Color.yellow);
    StatusCanvas GlobalSensorCanvas = new StatusCanvas("GlobalSensor", Color.yellow);
    StatusCanvas WarningSignalCanvas = new StatusCanvas("WarningSignal", Color.yellow);

    WarningSignal ws = new WarningSignal(WarningSignalCanvas);
    RoadController rc = new RoadController(ws, HouseCanvas, GateCanvas, MartinCourtyardCanvas, RoadCanvas, ExitCanvas);

    Button martinStart;
    Button STATUS;
    Button martinStop;
    Button enemyStart;
    Button enemyStop;

    EntrySensor roadsensor = new EntrySensor("road", ws, RoadSensorCanvas);
    EntrySensor mainsensor = new EntrySensor("main", ws, MainSensorCanvas);
    ExitSensor housesensor = new ExitSensor("house", ws, HouseSensorCanvas);
    ExitSensor globalsensor = new ExitSensor("global", ws, GlobalSensorCanvas);

    Choice enemyNumber;
    Label enemyLabel;

    Martin m;
    Enemy e1;
    Enemy e2;
    Enemy e3;

    private void startM() {
        m = new Martin(rc, housesensor, roadsensor, globalsensor, ws);
        m.start();
    }

    private void stopM() {
        if (m.isAlive()) {
            m.interrupt();
            // cleaning up the canvas for martin
            HouseCanvas.free("M");
            RoadCanvas.free("M");
            ExitCanvas.free("M");
            MartinCourtyardCanvas.free("M");
            rc.appletGateOff();
        }
    }

    private void startE() {

        if (enemyNumber.getSelectedItem() == "1") {
            if ((e1 == null) || (!e1.isAlive())) {
                e1 = new Enemy(mainsensor, globalsensor, rc, "E1");
                e1.start();
            }
        }
        if (enemyNumber.getSelectedItem() == "2") {
            if ((e2 == null) || (!e2.isAlive())) {
                e2 = new Enemy(mainsensor, globalsensor, rc, "E2");
                e2.start();
            }
        }
        if (enemyNumber.getSelectedItem() == "3") {
            if ((e3 == null) || (!e3.isAlive())) {
                e3 = new Enemy(mainsensor, globalsensor, rc, "E3");
                e3.start();
            }
        }

    }

    private void stopE() {

        if ((e1 != null) && ("1".equals(enemyNumber.getSelectedItem()))) {
            if (e1.isAlive()) {
                e1.interrupt();
            }
            GateCanvas.free("E1");
            RoadCanvas.free("E1");
            ExitCanvas.free("E1");
        }
        if ((e2 != null) && ("2".equals(enemyNumber.getSelectedItem()))) {
            if (e2.isAlive()) {
                e2.interrupt();
            }
            GateCanvas.free("E2");
            RoadCanvas.free("E2");
            ExitCanvas.free("E2");
        }

        if ((e3 != null) && ("3".equals(enemyNumber.getSelectedItem()))) {
            if (e3.isAlive()) {
                e3.interrupt();
            }
            GateCanvas.free("E3");
            RoadCanvas.free("E3");
            ExitCanvas.free("E3");
        }

    }

    public boolean handleEvent(Event event) {
        if (event.id == event.ACTION_EVENT && event.target == martinStart) {
            if ((m == null) || (!m.isAlive())) {
                startM();
            }
            return true;
        } else if (event.id == event.ACTION_EVENT && event.target == martinStop) {
            stopM();
            return true;
        } else if (event.id == event.ACTION_EVENT && event.target == enemyStart) {
            startE();
            return true;
        } else if (event.id == event.ACTION_EVENT && event.target == enemyStop) {
            stopE();
            return true;
        } else {
            return super.handleEvent(event);
        }
    }

    public void init() {
        super.init();
        // Set up Button and Checkbox
        setSize(getWidth() * 2, getHeight() * 2);
        // bottom panel
        Panel p0 = new Panel();
        p0.add(martinStart = new Button(" MartinStart "));
        p0.add(martinStop = new Button("MartinStop"));
        martinStart.setFont(new Font("Helvetica", Font.BOLD, 24));
        martinStop.setFont(new Font("Helvetica", Font.BOLD, 24));
        p0.add(enemyStart = new Button(" EnemyStart "));
        p0.add(enemyStop = new Button("EnemyStop"));
        enemyStart.setFont(new Font("Helvetica", Font.BOLD, 24));
        enemyStop.setFont(new Font("Helvetica", Font.BOLD, 24));

        enemyNumber = new Choice();
        enemyNumber.add("1");
        enemyNumber.add("2");
        enemyNumber.add("3");
        enemyLabel = new Label("Enemy Number:  ");
        enemyLabel.setFont(new Font("Helvetica", Font.BOLD, 24));
        p0.add(enemyLabel);
        p0.add(enemyNumber);

        p0.add(STATUS = new Button("STATUS"));

        Panel p1 = new Panel();
        p1.setLayout(new BorderLayout());
        p1.add("Center", p0);
        //p1.add("East");
        // Set up Display
        Panel p2 = new Panel();

        HouseCanvas.setSize(300, 100);
        MartinCourtyardCanvas.setSize(300, 100);
        GateCanvas.setSize(150, 100);
        RoadCanvas.setSize(300, 100);
        ExitCanvas.setSize(150, 100);

        p2.add("Center", RoadCanvas);
        Panel p3 = new Panel();
        p3.add(GateCanvas);
        Panel p4 = new Panel();
        p4.add(ExitCanvas);

        Panel p5 = new Panel();
        p5.add("Center", HouseCanvas);

        p5.add("South", MartinCourtyardCanvas);

        Panel p6 = new Panel(new BorderLayout());

// add Sensors canvas here
        Panel p7 = new Panel(new FlowLayout());
        WarningSignalCanvas.setSize(120, 50);

        RoadSensorCanvas.setSize(100, 50);
        MainSensorCanvas.setSize(100, 50);
        HouseSensorCanvas.setSize(100, 50);
        GlobalSensorCanvas.setSize(100, 50);

        p7.add(WarningSignalCanvas);
        p7.add(MainSensorCanvas);
        p7.add(HouseSensorCanvas);
        p7.add(GlobalSensorCanvas);
        p7.add(RoadSensorCanvas);

        p6.add("South", p1);
        p6.add("Center", p7);
// Arrange Applet display
        setLayout(new BorderLayout());
        add("West", p3);
        add("Center", p2);
        add("South", p6);
        add("East", p4);
        add("North", p5);
    }

    /*
  
  Checkbox fixit;
  Button StopButton;
  
    Turnstile east;
  Turnstile west;
  Counter counter;

  private void go() {
 
      if (!fixit.getState())
      counter = new Counter(counterD);
    else
      counter = new SynchronizedCounter(counterD);
    west= new Turnstile(westD,counter);
    east= new Turnstile(eastD,counter);
    west.start();
    east.start();
  
}
  
  private void stopper() {
      west.interrupt();
      east.interrupt();
  }

  public boolean handleEvent(Event event) {
    if (event.id == event.ACTION_EVENT && event.target==goButton) {
      if ((west==null && east==null)
	  || (!west.isAlive() && !east.isAlive()))
        go();
      return true;
    } 
    else if (event.id == event.ACTION_EVENT && event.target==StopButton) {
        if ( ! ( west.isAlive() && !east.isAlive() ) ) { stopper(); }
      return true;
    } 
    
    
       else
      return super.handleEvent(event);
    }
  
  public void init() {
    super.init();
    // Set up Button and Checkbox
      setSize(getWidth()*2,getHeight()*2);
    Panel p0= new Panel();
    p0.add(goButton = new Button(" Go "));
      System.out.println(p0.getSize());
    p0.add(StopButton = new Button("Stop"));
    StopButton.setFont(new Font("Helvetica",Font.BOLD,24));
    goButton.setFont(new Font("Helvetica",Font.BOLD,24));
    Panel p1= new Panel();
    p1.setLayout(new BorderLayout());
    p1.add("Center",p0);
    p1.add("East",fixit = new Checkbox("Fix It"));
    // Set up Display
    Panel p2 = new Panel();
    HouseCanvas = new StatusCanvas("HouseCanvas",Color.red);
    Waiting   = new StatusCanvas("Waiting",Color.green);
    GateCanvas  = new StatusCanvas("GateCanvas",Color.green);
    RoadCanvas  = new StatusCanvas("RoadCanvas",Color.green);
    
    HouseCanvas.setSize(150,100);
    Waiting.setSize(100,100);
    GateCanvas.setSize(100,100);
    RoadCanvas.setSize(100,200);
    p2.add(HouseCanvas);
    p2.add(Waiting);
    p2.add(RoadCanvas);
    p2.add(GateCanvas);
    // Arrange Applet display
    setLayout(new BorderLayout());
    add("Center",p2);
    add("South",p1);
     */
}
