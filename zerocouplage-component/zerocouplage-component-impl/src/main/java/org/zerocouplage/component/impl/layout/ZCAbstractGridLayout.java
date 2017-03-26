package org.zerocouplage.component.impl.layout;

import java.util.ArrayList;
import java.util.List;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.api.layout.ZCGridLayout;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
/**
 * <p>
 * ZCAbstractGridLayout is an implementation of the ZCGridLayout
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractGridLayout extends ZCAbstractLayout implements
		ZCGridLayout {

	private ArrayList<ZCComponent> component = new ArrayList<ZCComponent>();
	private List<nodePane> nodes = new ArrayList<ZCAbstractGridLayout.nodePane>();
	private int cols;
	private int rows;
	private int indexCols = 0;
	private int indexRows = 0;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public void addComponent(ZCComponent component) throws Exception {
		component.setParentName(this.getParentName());
		component.setParent(this);
		/* For Desktop */
		if (indexCols <= getCols()) {
			nodes.add(new nodePane(component, indexCols, indexRows));
			indexCols++;
		} else {
			indexCols = 0;
			indexRows++;
			nodes.add(new nodePane(component, indexCols, indexRows));
			indexCols++;

		}

		/* For Web */
		this.component.add(component);

	}

	public ZCComponent getComponent(int id) {
		ZCComponent tmpComponent = null;
		if (component.size() >= id) {
			tmpComponent = (ZCComponent) component.get(id);
		}
		return tmpComponent;

	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public ArrayList<ZCComponent> getComponent() {
		return component;
	}

	public void setComponent(ArrayList<ZCComponent> component) {
		this.component = component;
	}

	public List<nodePane> getNodes() {
		return nodes;
	}

	public void setNodes(List<nodePane> nodes) {
		this.nodes = nodes;
	}

	public int getIndexCols() {
		return indexCols;
	}

	public void setIndexCols(int indexCols) {
		this.indexCols = indexCols;
	}

	public int getIndexRows() {
		return indexRows;
	}

	public void setIndexRows(int indexRows) {
		this.indexRows = indexRows;
	}

	public class nodePane {
		private ZCComponent comp;
		private int indexOfComponentRow;// Pour JavaFX
		private int indexOfComponentCol;// pour JavaFX

		public ZCComponent getComp() {
			return comp;
		}

		public void setComp(ZCComponent comp) {
			this.comp = comp;
		}

		public int getIndexOfComponentRow() {
			return indexOfComponentRow;
		}

		public void setIndexOfComponentRow(int indexOfComponentRow) {
			this.indexOfComponentRow = indexOfComponentRow;
		}

		public int getIndexOfComponentCol() {
			return indexOfComponentCol;
		}

		public void setIndexOfComponentCol(int indexOfComponentCol) {
			this.indexOfComponentCol = indexOfComponentCol;
		}

		public nodePane(ZCComponent component, int indexOfComponentCol,
				int indexOfComponentRow) {
			this.comp = component;
			this.indexOfComponentCol = indexOfComponentCol;
			this.indexOfComponentRow = indexOfComponentRow;
		}

	}
}
