/*
 *  Copyright (c) 2014 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: InfoActivity.java
 */

package com.task4java.android.examples.activity;

import android.os.Bundle;
import android.widget.Button;

import com.task4java.android.activity.BaseActivity;
import com.task4java.android.annotation.Annotations.ViewMapping;
import com.task4java.android.examples.R;
import com.task4java.data.backend.model.MainMenuAnnotation;

@MainMenuAnnotation(description = "Description", group = "Help", priority = 0, title = "WelcomeActivity")
public class WelcomeActivity extends BaseActivity {

	@ViewMapping(resourceId = R.id.button1)
	private Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_welcome);

		initializeView();
	}
}
