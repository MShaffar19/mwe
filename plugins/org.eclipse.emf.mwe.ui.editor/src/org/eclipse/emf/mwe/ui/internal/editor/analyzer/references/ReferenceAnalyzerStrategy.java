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

package org.eclipse.emf.mwe.ui.internal.editor.analyzer.references;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.mwe.ui.internal.editor.elements.WorkflowElement;
import org.eclipse.jface.text.IDocument;

/**
 * @author Patrick Schoenbach
 * @version $Revision: 1.1 $
 */
public class ReferenceAnalyzerStrategy extends AbstractReferenceAnalyzerStrategy {

    public ReferenceAnalyzerStrategy(final IFile file, final IDocument document,
            final ReferenceInfoStore store) {
        super(file, document, store);
    }

    /**
     * This method overrides the implementation of <code>isApplicable</code>
     * inherited from the superclass.
     * 
     * @see org.eclipse.emf.mwe.ui.internal.editor.analyzer.references.IReferenceAnalyzerStrategy#isApplicable(org.eclipse.emf.mwe.ui.internal.editor.elements.WorkflowElement)
     */
    public boolean isApplicable(final WorkflowElement element) {
        return element.hasAttribute(WorkflowElement.ID_REF_ATTRIBUTE);
    }

    /**
     * This method overrides the implementation of <code>doAnalyze</code>
     * inherited from the superclass.
     * 
     * @see org.eclipse.emf.mwe.ui.internal.editor.analyzer.references.AbstractReferenceAnalyzerStrategy#doAnalyze(org.eclipse.emf.mwe.ui.internal.editor.elements.WorkflowElement)
     */
    @Override
    protected void doAnalyze(final WorkflowElement element) {
        store.addReference(element);
    }
}