package Pattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
 
/**
 * This class represents a bar chart view of a vector of data. Uses the Observer
 * pattern.
 */
@SuppressWarnings("serial")
public class PieChartObserver extends JPanel implements Observer {
	/**
	 * Creates a BarChartObserver object
	 * 
	 * @param data
	 *            a CourseData object to observe
	 */
	public PieChartObserver(CourseData data) {
		data.attach(this);
		this.courseData = data.getUpdate();
		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.courseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.setBackground(Color.white);
	}

	/**
	 * Paint method
	 * 
	 * @param g
	 *            a Graphics object on which to paint
	 */
	public void paint(Graphics g) {
		super.paint(g);
		int radius = 100;
        int centerX = LayoutConstants.xOffset + radius;
        int centerY = LayoutConstants.yOffset + radius;
        double total = 0.0;

        // Calculate total value
        for (CourseRecord record : this.courseData) {
            total += record.getNumOfStudents();
        }
        if (total == 0) {
            return;
        }

        double startAngle = 0.0;

        for (int i = 0; i < this.courseData.size(); i++) {
            CourseRecord record = this.courseData.get(i);
            double value = record.getNumOfStudents();
            double ratio = value / total;
            double arcAngle = ratio * 360.0;

            g.setColor(LayoutConstants.courseColours[i % LayoutConstants.courseColours.length]);
            g.fillArc(LayoutConstants.xOffset - 200 + (LayoutConstants.barWidth * (this.courseData.size() + 1)), LayoutConstants.yOffset,
                    2 * radius, 2 * radius,
                    (int) startAngle, (int) arcAngle);

            double midAngleRad = Math.toRadians(startAngle + arcAngle / 2.0);
            int labelRadius = (int) (radius * 1.2); 
            int labelX = (int) (centerX + labelRadius * Math.cos(midAngleRad));
            int labelY = (int) (centerY - labelRadius * Math.sin(midAngleRad));

            g.setColor(Color.black);
            g.drawString(record.getName(), labelX, labelY);

            startAngle += arcAngle;
        }
	}

	/**
	 * Informs this observer that the observed CourseData object has changed
	 * 
	 * @param o
	 *            the observed CourseData object that has changed
	 */
	public void update(Observable o) {
		CourseData data = (CourseData) o;
		this.courseData = data.getUpdate();

		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.courseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.revalidate();
		this.repaint();
	}

	private ArrayList<CourseRecord> courseData;
}