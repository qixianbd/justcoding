package keyming.learning.justcoding.ruleengine;

public enum CmpType {
	EQ, LT, GT, LE, GE;
	public String toString() {
		switch(this) {
		case EQ:
			return "equal";
		case LT:
			return "lessThan";
		case GT:
			return "greatThan";
		case LE:
			return "lessOrEqual";
		case GE:
			return "greatOrEqual";
		default:
			return "equal";
		}
	}
}
