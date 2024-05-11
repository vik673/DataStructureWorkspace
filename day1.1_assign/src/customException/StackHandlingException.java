package customException;

@SuppressWarnings("serial")
public class StackHandlingException extends Exception{
	public StackHandlingException(String errMsg) {
		super(errMsg);
	}
}
