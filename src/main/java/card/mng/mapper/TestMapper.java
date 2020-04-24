package card.mng.mapper;

import card.mng.dto.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TestMapper {
    //@Select("select * from test")
    List<TestModel> getAllTest();

    //@Insert("insert into test values (#{testId},#{testData})")
    int addTest (TestModel testModel);

}
