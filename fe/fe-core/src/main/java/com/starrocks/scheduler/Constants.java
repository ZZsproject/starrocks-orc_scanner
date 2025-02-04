// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.starrocks.scheduler;

public class Constants {

    public enum TaskType {
        // For Task that can be triggered repeatedly by external.
        MANUAL,
        // For Task that schedules generated by internal periodically.
        PERIODICAL,
        // for Task that is executed asynchronously can be triggered by internal event
        EVENT_TRIGGERED
    }

    public enum TaskState {
        // For TaskType NORMAL TaskState is UNKNOWN.
        UNKNOWN,
        // For TaskType PERIODICAL when TaskState is ACTIVE it means scheduling works.
        ACTIVE,
        PAUSE
    }

    // TaskSource is used to distinguish special Processors for processing tasks from different sources.
    public enum TaskSource {
        CTAS,
        MV,
        INSERT
    }

    // PENDING -> RUNNING -> FAILED
    //                    -> SUCCESS
    public enum TaskRunState {
        PENDING,
        RUNNING,
        FAILED,
        SUCCESS,
    }

    // Used to determine the scheduling order of Pending TaskRun to Running TaskRun
    // The bigger the priority, the higher the priority, the default value is LOWEST
    public enum TaskRunPriority {
        LOWEST(0), LOW(20), NORMAL(50), HIGH(80), HIGHEST(100);

        private final int value;

        TaskRunPriority(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

}
