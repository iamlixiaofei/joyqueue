/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jd.joyqueue.client.internal.consumer.support;

import com.jd.joyqueue.client.internal.consumer.callback.PollerListener;
import com.jd.joyqueue.client.internal.consumer.domain.ConsumeMessage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuturePollerListener
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2019/7/25
 */
public class CompletableFuturePollerListener implements PollerListener {

    private CompletableFuture<List<ConsumeMessage>> future;

    public CompletableFuturePollerListener(CompletableFuture<List<ConsumeMessage>> future) {
        this.future = future;
    }

    @Override
    public void onMessage(List<ConsumeMessage> messages) {
        future.complete(messages);
    }

    @Override
    public void onException(Throwable cause) {
        future.completeExceptionally(cause);
    }
}