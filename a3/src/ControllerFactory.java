
public class ControllerFactory {
	
	public static ConnectController makeController(GameDisplay
			gd) {
		return new ConnectLogic(gd);
	}
}