package com.hrm.dp;

import com.hrm.filereader.YamlFileReader;
import com.hrm.models.TestCaseModel;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestDataProvider {

    private static final String TEST_DATA_FOLDER_PATH = "src/test/resources/testData/";
    private final YamlFileReader yamlFileReader;

    public TestDataProvider() {
        yamlFileReader = new YamlFileReader();
    }

    @DataProvider(name = "testData", parallel = true)
    public Object[][] commonDataProvider(final Method method) {
        Map<String, TestCaseModel> dataMap = this.getTestDatainMap(method.getName());
        Object[][] tests = new Object[dataMap.size()][1];
        AtomicInteger i = new AtomicInteger();
        dataMap.forEach((key, testdata) -> {
            final int index = i.getAndIncrement();
            tests[index][0] = testdata;
        });
        return tests;
    }

    private Map<String, TestCaseModel> getTestDatainMap(final String methodName) {
        final String tesdataPath = TEST_DATA_FOLDER_PATH + methodName + ".yml";
        final List<TestCaseModel> testdataList = yamlFileReader.readList(new File(tesdataPath), TestCaseModel.class);
        return testdataList.stream().collect(Collectors.toMap(TestCaseModel::getTestcaseName, x-> x));
    }
}
