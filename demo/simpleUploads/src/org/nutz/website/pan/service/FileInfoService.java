package org.nutz.website.pan.service;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.IdEntityService;
import org.nutz.website.pan.bean.FileInfo;

@IocBean(fields={"dao"})
public class FileInfoService extends IdEntityService<FileInfo> {

}
