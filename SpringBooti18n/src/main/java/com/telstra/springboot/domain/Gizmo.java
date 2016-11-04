package com.telstra.springboot.domain;

import java.util.ArrayList;
import java.util.List;

public class Gizmo {
	 
    private String field1;
    private String field2;
    private List<GizmoChild>  children = new ArrayList<GizmoChild>();
 
    public String getField1() {
        return field1;
    }
 
    public void setField1(String field1) {
        this.field1 = field1;
    }
 
    public String getField2() {
        return field2;
    }
 
    public void setField2(String field2) {
        this.field2 = field2;
    }

	public List<GizmoChild> getChildren() {
        return children;
	}

	public void setChildren(List<GizmoChild> children) {
		this.children = children;
	}
}