/*******************************************************************************
 * Copyright (c) 2008 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.mwe.ewm.workflow;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.mwe.ewm.workflow.orchestration.WorkflowComponentOrchestrationStrategy;
import org.eclipse.emf.mwe.ewm.workflow.runtime.IWorkflowVisitor;
import org.eclipse.emf.mwe.ewm.workflow.runtime.WorkflowContext;
import org.eclipse.emf.mwe.ewm.workflow.runtime.WorkflowRuntimeException;
import org.eclipse.emf.mwe.ewm.workflow.runtime.state.WorkflowState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow Component</b></em>'.  This is the abstract base class for
 * all modeled workflows.  This class is not intended to be extended.  Clients should extend WorkflowUnitOfWork.
 * 
 * An orchestration strategy must be specified for each workflow component instance.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.mwe.ewm.workflow.WorkflowComponent#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.mwe.ewm.workflow.WorkflowComponent#getComponentOrchestrationStrategy <em>Component Orchestration Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.mwe.ewm.workflow.WorkflowPackage#getWorkflowComponent()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class WorkflowComponent extends EObjectImpl implements EObject
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponentOrchestrationStrategy() <em>Component Orchestration Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentOrchestrationStrategy()
	 * @generated
	 * @ordered
	 */
	protected WorkflowComponentOrchestrationStrategy componentOrchestrationStrategy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowComponent()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return WorkflowPackage.Literals.WORKFLOW_COMPONENT;
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.mwe.ewm.workflow.WorkflowPackage#getWorkflowComponent_Name()
	 * @model required="true"
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.emf.mwe.ewm.workflow.WorkflowComponent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW_COMPONENT__NAME, oldName, name));
	}

	/**
	 * Returns the value of the '<em><b>Component Orchestration Strategy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Orchestration Strategy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Orchestration Strategy</em>' containment reference.
	 * @see #setComponentOrchestrationStrategy(WorkflowComponentOrchestrationStrategy)
	 * @see org.eclipse.emf.mwe.ewm.workflow.WorkflowPackage#getWorkflowComponent_ComponentOrchestrationStrategy()
	 * @model containment="true"
	 * @generated
	 */
	public WorkflowComponentOrchestrationStrategy getComponentOrchestrationStrategy()
	{
		return componentOrchestrationStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentOrchestrationStrategy(WorkflowComponentOrchestrationStrategy newComponentOrchestrationStrategy, NotificationChain msgs)
	{
		WorkflowComponentOrchestrationStrategy oldComponentOrchestrationStrategy = componentOrchestrationStrategy;
		componentOrchestrationStrategy = newComponentOrchestrationStrategy;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY, oldComponentOrchestrationStrategy, newComponentOrchestrationStrategy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.emf.mwe.ewm.workflow.WorkflowComponent#getComponentOrchestrationStrategy <em>Component Orchestration Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Orchestration Strategy</em>' containment reference.
	 * @see #getComponentOrchestrationStrategy()
	 * @generated
	 */
	public void setComponentOrchestrationStrategy(WorkflowComponentOrchestrationStrategy newComponentOrchestrationStrategy)
	{
		if (newComponentOrchestrationStrategy != componentOrchestrationStrategy)
		{
			NotificationChain msgs = null;
			if (componentOrchestrationStrategy != null)
				msgs = ((InternalEObject)componentOrchestrationStrategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY, null, msgs);
			if (newComponentOrchestrationStrategy != null)
				msgs = ((InternalEObject)newComponentOrchestrationStrategy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY, null, msgs);
			msgs = basicSetComponentOrchestrationStrategy(newComponentOrchestrationStrategy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY, newComponentOrchestrationStrategy, newComponentOrchestrationStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Clients must override this function to perform the work of the workflow component.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	public abstract WorkflowState run(WorkflowContext context) throws WorkflowRuntimeException;

	/**
	 * <!-- begin-user-doc -->
	 * Clients must override this function and call the appropriate visitor function.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	public abstract void accept(IWorkflowVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	public final void start(WorkflowContext context)
	{
		getComponentOrchestrationStrategy().run(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY:
				return basicSetComponentOrchestrationStrategy(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case WorkflowPackage.WORKFLOW_COMPONENT__NAME:
				return getName();
			case WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY:
				return getComponentOrchestrationStrategy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case WorkflowPackage.WORKFLOW_COMPONENT__NAME:
				setName((String)newValue);
				return;
			case WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY:
				setComponentOrchestrationStrategy((WorkflowComponentOrchestrationStrategy)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case WorkflowPackage.WORKFLOW_COMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY:
				setComponentOrchestrationStrategy((WorkflowComponentOrchestrationStrategy)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case WorkflowPackage.WORKFLOW_COMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkflowPackage.WORKFLOW_COMPONENT__COMPONENT_ORCHESTRATION_STRATEGY:
				return componentOrchestrationStrategy != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		return name;
	}

} // WorkflowComponent