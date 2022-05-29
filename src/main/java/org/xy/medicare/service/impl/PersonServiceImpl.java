package org.xy.medicare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xy.medicare.dao.IPersonDAO;
import org.xy.medicare.entity.Person;
import org.xy.medicare.service.IPersonService;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:Person类的服务层实现
 * @author: XY-GYL
 * @time: 2022/5/28 19:09
 */

@Service
public class PersonServiceImpl extends ServiceImpl<IPersonDAO, Person> implements IPersonService {

    /**
     * 根据账号新建用户个人信息并封装信息到res中
     *
     * @param account 账号
     * @return 包含用户信息的Map
     */
    @Override
    public Map<String, String> newNullPersonSer(String account){
        Map<String, String> map = new HashMap<>();
        int res = query().eq("account", account).count();
        if (res >= 1) {
            //个人信息已存在
            map.put("res", "-1");
        } else {
            //个人信息未创建
            boolean suc = baseMapper.insertNULLIntoPerson(account);
            if (suc) {
                map.put("res", "1");
            } else {
                map.put("res", "2");
            }
        }
        return map;
    }

    /**
     * 根据账号删除用户个人信息
     * @param account 账号
     * @return 修改结果
     */
    @Override
    public boolean deletePersonByAccountSer(String account){
        return baseMapper.deletePersonByAccountDAO(account);
    }
}
