/*
 * Copyright (c) 2008 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    committers of openArchitectureWare - initial API and implementation
 */

package org.eclipse.emf.mwe.ui.editor.outline;

import org.eclipse.emf.mwe.ui.editor.elements.WorkflowElement;
import org.eclipse.emf.mwe.ui.editor.internal.images.EditorImages;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * @author Patrick Schoenbach
 * @version $Revision: 1.2 $
 */

public class WorkflowLabelProvider implements ILabelProvider {
    public void addListener(final ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public Image getImage(final Object element) {
        if (element instanceof WorkflowElement)
            return EditorImages.getImage((String) element);
        return null;
    }

    public String getText(final Object element) {
        if (element instanceof WorkflowElement)
            return ((WorkflowElement) element).getName();
        return null;
    }

    public boolean isLabelProperty(final Object element, final String property) {
        return false;
    }

    public void removeListener(final ILabelProviderListener listener) {
    }
}