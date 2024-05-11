package customException;

@SuppressWarnings("serial")
public class QueueHandlingException extends Exception{
	public QueueHandlingException(String errMsg) {
		super(errMsg);
	}
}
