/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.testing.jacoco.tasks;

import org.gradle.api.Task;
import org.gradle.api.reporting.SingleFileReport;
import org.gradle.api.reporting.internal.TaskGeneratedSingleDirectoryReport;
import org.gradle.api.reporting.internal.TaskGeneratedSingleFileReport;
import org.gradle.api.reporting.internal.TaskReportContainer;

public class JacocoReportsContainerImpl extends TaskReportContainer<SingleFileReport> implements JacocoReportsContainer {

    public JacocoReportsContainerImpl(Task task) {
        super(SingleFileReport.class, task);
        add(TaskGeneratedSingleDirectoryReport.class, "html", task);
        add(TaskGeneratedSingleFileReport.class, "xml", task);
        add(TaskGeneratedSingleFileReport.class, "csv", task);
    }

    public SingleFileReport getHtml() {
        return getByName("html");
    }

    public SingleFileReport getXml() {
        return getByName("xml");
    }

    public SingleFileReport getCsv() {
        return getByName("csv");
    }
}
