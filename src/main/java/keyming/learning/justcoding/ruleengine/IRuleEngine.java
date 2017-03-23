package keyming.learning.justcoding.ruleengine;

public interface IRuleEngine {
	public void addRule(IRule rule);
	
	public void beginEvaluate(IRule rule, IEventData data);
	
	public void onSuccess(IRule rule, IEventData data);
	
	public void onFailure(IRule rule, IEventData data);
}
