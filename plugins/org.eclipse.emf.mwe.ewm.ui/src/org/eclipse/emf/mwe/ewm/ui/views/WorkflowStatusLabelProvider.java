/*******************************************************************************
 * Copyright (c) 2009 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.mwe.ewm.ui.views;

import java.util.Calendar;

import org.eclipse.emf.mwe.ewm.workflow.WorkflowComponent;
import org.eclipse.emf.mwe.ewm.workflow.runtime.WorkflowContext;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author bhunt
 *
 */
public class WorkflowStatusLabelProvider extends LabelProvider implements ITableLabelProvider
{

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex)
	{
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex)
	{
		WorkflowComponent component = (WorkflowComponent) element;
		
		switch(columnIndex)
		{
			case 0:
				return component.getName();
				
			case 1:
			{
				Calendar calendar = Calendar.getInstance();
				long startTime = context.getExecutionInfo().get(component).getStartTime();
				
				if(startTime != 0)
				{
					calendar.setTimeInMillis(startTime);
					return calendar.toString();
				}
				
				return "Unknown";
			}
			
			case 2:
			{
				Calendar calendar = Calendar.getInstance();
				long endTime = context.getExecutionInfo().get(component).getEndTime();
				
				if(endTime != 0)
				{
					calendar.setTimeInMillis(endTime);
					return calendar.toString();
				}
				
				return "Unknown";
			}
			
			case 3:
				return context.getStates().get(component).getDisplayName();
		}
		
		return null;
	}

	public void setContext(WorkflowContext context)
	{
		this.context = context;
	}
	
	private WorkflowContext context;
}