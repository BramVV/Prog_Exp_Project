package be.pxl.rest.mirror.service;

import be.pxl.rest.mirror.entity.Call;
import be.pxl.rest.mirror.repository.MirrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bram on 19/10/2016.
 */
@Service
@Transactional
public class MirrorServiceImpl implements MirrorService {
    @Autowired
    private MirrorRepository mirrorRepository;
    
    @Override
    public void storeCall (Call call) {
        mirrorRepository.save(call);
    }
}
