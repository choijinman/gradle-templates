/*
 * Copyright (c) 2011,2012 Eric Berry <elberry@tellurianring.com>
 * Copyright (c) 2013 Christopher J. Stehno <chris@stehno.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package templates.tasks.scala
import org.junit.Test
import templates.AbstractTaskTester

import static templates.tasks.scala.CreateScalaClassTask.NEW_CLASS_NAME

class CreateScalaClassTaskTest extends AbstractTaskTester {

    CreateScalaClassTaskTest(){
        super( CreateScalaClassTask )
    }

    @Test void create(){
        project.apply plugin:'scala'

        project.ext[NEW_CLASS_NAME] = 'foo.Something'

        task.create()

        assertFileContains testRoot, 'src/main/scala/foo/Something.scala', 'class Something'
    }
}
