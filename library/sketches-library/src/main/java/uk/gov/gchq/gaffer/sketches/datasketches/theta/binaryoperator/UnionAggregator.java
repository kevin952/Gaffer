/*
 * Copyright 2016 Crown Copyright
 *
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
package uk.gov.gchq.gaffer.sketches.datasketches.theta.binaryoperator;

import com.yahoo.sketches.theta.Union;
import uk.gov.gchq.koryphe.binaryoperator.KorypheBinaryOperator;

/**
 * A <code>UnionAggregator</code> is a {@link java.util.function.BinaryOperator} that aggregates {@link Union}s.
 * It does this by extracting a {@link com.yahoo.sketches.theta.CompactSketch} from each {@link Union}
 * and merges that using {@link Union#update(com.yahoo.sketches.theta.Sketch)}.
 */
public class UnionAggregator extends KorypheBinaryOperator<Union> {
    @Override
    protected Union _apply(final Union a, final Union b) {
        a.update(b.getResult());
        return a;
    }
}