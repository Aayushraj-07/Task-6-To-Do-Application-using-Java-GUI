package view;

import javax.swing.*;
import java.awt.*;

public class PriorityCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        String task = value.toString();
        if (task.startsWith("High")) {
            c.setForeground(Color.RED);
        } else if (task.startsWith("Medium")) {
            c.setForeground(Color.ORANGE);
        } else if (task.startsWith("Low")) {
            c.setForeground(Color.GREEN);
        }
        return c;
    }
}
