/* Frame  -> AWT
 * JFrame -> Swing
*/
import javax.swing.*;
import java.awt.*;
class BB {
	Frame f;
	JFrame jf;
	BB(){
		f = new Frame();
		f.setTitle("AWT");
		f.setSize(300,300);
		f.setVisible(true);
		
		jf = new JFrame();
		jf.setTitle("세번째 프레임");
		jf.setSize(300,300);
		jf.setVisible(true);
	}
}
public class Exam_03 {
	public static void main(String[] args) {
		new BB();
	}
}
