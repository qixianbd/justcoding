package keyming.learning.justcoding.ruleengine;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AtomicCondition implements ICondition{
	private String metricName;
	CmpType cmp;
	private double threshold;
	public boolean evaluate(Object data) {
		// TODO Auto-generated method stub
		return false;
	}
}
