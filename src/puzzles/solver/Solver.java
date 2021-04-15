package puzzles.solver;

import java.util.*;

public class Solver {
    private  Configurations start;
    private int totalConfig;
    private Map<Configurations, Configurations> map = new HashMap<>();
    private List<Configurations> path = new LinkedList<>();
    Queue<Configurations> config = new LinkedList<>();

    public Solver(Configurations start, Map<Configurations, Configurations> map, List<Configurations> path,  Queue<Configurations> config) {
        this.start = start;
        this.map = map;
        this.path = path;
        this.config = config;
    }

    public List<Configurations> solve() {
        this.config.add(this.start);
        this.map.put(this.start, null);
        Configurations current = this.config.remove();
        while (!this.config.isEmpty()) {
            if ( current.isgoal() ) {
                if( this.map.containsKey( this.start )){
                    while ( this.start.equals( current ) ){
                        this.path.add( 0, this.start );
                        this.start = this.map.get( this.start );
                    }
                    this.path.add( 0, current );
                    return this.path;
                }
                for ( Configurations con : current.getsuccessors() ){
                    if ( !this.map.containsKey( con ) ){
                        this.map.put( con, current);
                        this.config.add( con );
                    }
                }
            }
        }

        return null;//returns empty
    }
}
