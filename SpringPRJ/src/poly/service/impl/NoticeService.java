package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import poly.dto.NoticeDTO;
import poly.dto.UserDTO;
import poly.persistance.mapper.NoticeMapper;
import poly.service.INoticeService;

@Service("NoticeService")
public class NoticeService implements INoticeService {

   @Resource(name = "NoticeMapper")
   private NoticeMapper noticeMapper;

}