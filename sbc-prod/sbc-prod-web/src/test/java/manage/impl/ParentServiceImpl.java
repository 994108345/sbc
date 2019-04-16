package manage.impl;

import com.alibaba.fastjson.JSONObject;
import data.Parent;
import manage.ManageService;

/**
 * @author wzl
 * @date Created in 2019/4/9 17:18
 */
public class ParentServiceImpl implements ManageService {
    @Override
    public void getTest(Parent parent) {
        System.out.println(JSONObject.toJSONString(parent));
    }
}
