package cn.liuyiyou.springboot.elasticsearch;

import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * 将百度云的文件名批量修改
 *
 * @author: liuyiyou.cn
 * @date: 2019/9/2
 * @version: V1.0
 */
public class ModifyFileName {


    @Test
    public void moidfyFilename() throws IOException {
        final Collection<File> listFiles = FileUtils.listFiles(new File("F:\\BaiduNetdiskDownload\\"), FileFilterUtils.fileFileFilter(), FileFilterUtils.directoryFileFilter());
//        final Collection<File> listFiles = FileUtils.listFiles(new File("F:\\BaiduNetdiskDownload\\46 数据结构与算法之美"), FileFilterUtils.fileFileFilter(), FileFilterUtils.directoryFileFilter());
        for (File file : listFiles) {
            if (file.getName().contains("【加qq 651470923 获取更多课程】") || file.getName().contains("[加qq 651470923 获取更多课程]")) {
                String destFileName = file.getName().replace("【加qq 651470923 获取更多课程】", "").replace("[加qq 651470923 获取更多课程]", "");
//                final File file1 = new File(file.getParent()+destFileName);
                FileUtil.rename(file, destFileName, false, true);
            }
        }
    }
}
