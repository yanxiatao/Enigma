/*******************************************************************************
 * Copyright (c) 2015 Jeff Martin.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public
 * License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Contributors:
 * Jeff Martin - initial API and implementation
 ******************************************************************************/

package cuchaz.enigma.gui;

import cuchaz.enigma.analysis.MethodInheritanceTreeNode;
import cuchaz.enigma.gui.config.Config;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

class MethodTreeCellRenderer implements TreeCellRenderer {

	private final TreeCellRenderer parent;

	MethodTreeCellRenderer(TreeCellRenderer parent) {
		this.parent = parent;
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		Component ret = parent.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		Config config = Config.getInstance();
		if (!(value instanceof MethodInheritanceTreeNode) || ((MethodInheritanceTreeNode) value).isImplemented()) {
			ret.setForeground(new Color(config.defaultTextColor));
			ret.setFont(ret.getFont().deriveFont(Font.PLAIN));
		} else {
			ret.setForeground(new Color(config.numberColor));
			ret.setFont(ret.getFont().deriveFont(Font.ITALIC));
		}
		return ret;
	}
}
