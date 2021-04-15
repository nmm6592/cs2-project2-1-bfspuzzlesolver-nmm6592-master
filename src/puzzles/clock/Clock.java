package puzzles.clock;

import puzzles.solver.Configurations;
import puzzles.solver.Solver;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Clock implements Configurations {
    private final int hours;
    private final int start;
    private final int end;
    private int current;

    public Clock(int hours, int start, int end) {
        this.hours = hours;
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Clock hours start stop");
        }
    }

    public Clock( int hours, int start, int end, int current ) {
        this.hours = hours;
        this.start = start;
        this.end = end;
        this.current = current;

    }

    @Override
    public Collection<Configurations> getsuccessors() {
        List<Configurations> clock = new LinkedList<>();
        Clock clock1 = new Clock( this.hours +1  , this.start, this.end );
        Clock clock2 = new Clock( this.hours -1  , this.start, this.end  );
        if ( this.current == this.hours ){
            this.current = 1;
            clock1 = new Clock( this.hours , this.start, this.end, this.current  );
        }else {
            clock1 = new Clock( this.hours , this.start, this.end, this.current +1 );
        }
        if( this.current == 1){
            this.current = this.hours -1;
            clock2 = new Clock( this.hours , this.start, this.end, current );
        }else{
            clock2 = new Clock( this.hours , this.start, this.end, this.current -1 );
        }
        clock.add( clock1 );
        clock.add( clock2 );
        return clock;
    }

    @Override
    public Boolean isgoal() {
        return this.end == this.hours;
    }

    @Override
    public String toString() {
        System.out.println( "Hours: " + this.hours + "," + " Start: " + this.start + "," + " End: " + this.end );
        return null;
    }
}