package keyming.learning.justcoding;

import keyming.learning.justcoding.ruleengine.AtomicCondition;
import keyming.learning.justcoding.ruleengine.CmpType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * Hello world!
 *
 */
@Log4j
public class App 
{
    public static void main( String[] args )
    {
    	AtomicCondition condition = AtomicCondition.builder()
    			.metricName("cpu")
    			.cmp(CmpType.EQ)
    			.threshold(0.95f).build();
        System.out.println( "Hello World!" );
        log.error("haha" + condition.toString());
        
        Tree tree = new Tree();
        log.error(tree.toString() + tree.getHigh());
        Plants p = new Plants(5);
        log.error(p.toString());
        
        WorkDay wk = WorkDay.FRIDAY;
        log.error("wk is " + wk.name() + ", value is " + wk.ordinal());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Plants {
	private int high;
}

@Data
class Tree extends Plants {
	private String treeName;
	Tree(String treeName) {
		super(1);
		this.treeName = treeName;
	}
	public Tree() {
		this("appleTree");
	}
	
}

enum WorkDay {
	MONDAY, TDUSEDAY, WENSDAY, THIRDSAY, FRIDAY
}