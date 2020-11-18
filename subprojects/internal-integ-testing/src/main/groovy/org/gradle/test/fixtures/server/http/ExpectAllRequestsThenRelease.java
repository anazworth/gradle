/*
 * Copyright 2017 the original author or authors.
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

package org.gradle.test.fixtures.server.http;

import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.locks.Lock;

class ExpectAllRequestsThenRelease extends ExpectMaxNConcurrentRequests {
    ExpectAllRequestsThenRelease(Lock lock, int testId, Duration timeout, WaitPrecondition previous, Collection<? extends ResourceExpectation> expectations) {
        super(lock, testId, timeout, expectations.size(), previous, expectations);
    }

    @Override
    protected boolean isAutoRelease() {
        return true;
    }

    @Override
    protected void onExpectedRequestsReceived(BlockingHttpServer.BlockingHandler handler, int yetToBeReceived) {
        handler.releaseAll();
    }
}
