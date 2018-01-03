import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * a little description
 *
 * @author
 */
public class HelloVelocity {
    public static void main(String[] args) {
        // 1. 初始化Velocity模板引擎
        VelocityEngine ve = new VelocityEngine();
        // velocity的属性值有哪些需要进行设置？
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        // 2. 加载模板文件到内存中，并根据AST解析为Template
        Template t = ve.getTemplate("hellovelocity.vm");

        // 3. 设置velocity上下文，添加需要转换的变量及值
        VelocityContext ctx = new VelocityContext();
        // value值类型可以是哪些？
        ctx.put("name", "Velocity");
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        ctx.put("list", list);

        // 4. 合并并输出，也可以对HttpResponse的Writer进行merge
        StringWriter sw = new StringWriter();
        // 将merge后的内容写入writer中
        t.merge(ctx,sw);

        // 5. 打印合并后的内容
        System.out.println(sw.toString());
    }
}
