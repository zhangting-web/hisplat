package com.mh.hisplat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.Register;
import com.mh.hisplat.bean.User;
import com.mh.hisplat.dao.RegisterMapper;
import com.mh.hisplat.service.RegisterService;
import com.mh.hisplat.utils.CommenUtils;
import com.mh.hisplat.utils.PageRequest;
import com.mh.hisplat.utils.PageResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;
import java.util.Date;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private CommenUtils commenUtils;
    @Override
    public void insert(Register register) {
        register.setId(commenUtils.getId());
        register.setCreateTime(new Date());
        register.setUpdateTime(new Date());
        register.setrState(1);//数据字典
        //当前操作用户
      User sessionUser=(User)  SecurityUtils.getSubject().getPrincipal();
        register.setuId(sessionUser.getuId());
        registerMapper.insert(register);
    }

    @Override
    public PageInfo selectPageList(Register register, PageRequest pageRequest) {
       //启动分页监听
        PageHelper.startPage(pageRequest.getPageNo(), pageRequest.getPageSize());
        User sessionUser = (User) SecurityUtils.getSubject().getPrincipal();
        //用户id从当前session缓存中取
        register.setuId(sessionUser.getuId());
        List<Register> list=registerMapper.selectByRegister(register);
        for(int a= 0,length = list.size();a<length;a++){
            Register r=list.get(a);
            //0检查/诊断，1治疗/手术，2复诊
            if(r.getrSex()==0){
                r.setrSexName("女");
            }else if(r.getrSex()==1){
                r.setrSexName("男");
            }
        }
        for(int i = 0,length = list.size();i<length;i++){
            Register r=list.get(i);
            //0检查/诊断，1治疗/手术，2复诊
            if(r.getrType()==0){
                r.setrTypeName("检查/诊断");
            }else if(r.getrType()==1){
                r.setrTypeName("治疗/手术");
            }else if(r.getrType()==2){
                r.setrTypeName("复诊");
            }

        }

        //PageResult
        return new PageInfo<Register>(list);

    }

    @Override
    public PageInfo selectDocPageList(Register register, PageRequest pageRequest) {
        //启动分页监听
        PageHelper.startPage(pageRequest.getPageNo(), pageRequest.getPageSize());
        User sessionUser = (User) SecurityUtils.getSubject().getPrincipal();
        //用户id从当前session缓存中取
        register.setDocId(sessionUser.getuId());
        List<Register> list=registerMapper.selectByRegister(register);
        for(int a= 0,length = list.size();a<length;a++){
            Register r=list.get(a);
            //0检查/诊断，1治疗/手术，2复诊
            if(r.getrSex()==0){
                r.setrSexName("女");
            }else if(r.getrSex()==1){
                r.setrSexName("男");
            }
        }
        for(int i = 0,length = list.size();i<length;i++){
            Register r=list.get(i);
            //0检查/诊断，1治疗/手术，2复诊
            if(r.getrType()==0){
                r.setrTypeName("检查/诊断");
            }else if(r.getrType()==1){
                r.setrTypeName("治疗/手术");
            }else if(r.getrType()==2){
                r.setrTypeName("复诊");
            }

        }

        //PageResult
        return new PageInfo<Register>(list);

    }

    @Override
    public void delDocList(List list) {
        Register register=new Register();
        register.setDelFlag(1);
        register.setIds(list);
        registerMapper.updateByPrimaryKeys(register);
    }

    @Override
    public Register getById(Register register) {
        register= registerMapper.selectByPrimaryKey(register.getId());
        User sessionUser = (User)SecurityUtils.getSubject().getPrincipal();
        register.setDocName(sessionUser.getName());
        return register;
    }

    @Override
    public PageInfo selectDocBynamelist(Register register, PageRequest pageRequest) {
        //启动分页监听
        PageHelper.startPage(pageRequest.getPageNo(), pageRequest.getPageSize());
        User sessionUser = (User) SecurityUtils.getSubject().getPrincipal();
        //用户id从当前session缓存中取
        register.setuId(sessionUser.getuId());
        List<Register> list=registerMapper.selectDocBynamelist(register);
        for(int a= 0,length = list.size();a<length;a++){
            Register r=list.get(a);
            //0检查/诊断，1治疗/手术，2复诊
            if(r.getrSex()==0){
                r.setrSexName("女");
            }else if(r.getrSex()==1){
                r.setrSexName("男");
            }
        }
        for(int i = 0,length = list.size();i<length;i++){
            Register r=list.get(i);
            //0检查/诊断，1治疗/手术，2复诊
            if(r.getrType()==0){
                r.setrTypeName("检查/诊断");
            }else if(r.getrType()==1){
                r.setrTypeName("治疗/手术");
            }else if(r.getrType()==2){
                r.setrTypeName("复诊");
            }

        }

        //PageResult
        return new PageInfo<Register>(list);

    }

    @Override
    public void updaterStateById(String out_trade_no) {
        Register register=new Register();
        register.setId(out_trade_no);
        register.setrState(2);
        registerMapper.updateByPrimaryKeySelective(register);
    }

}
