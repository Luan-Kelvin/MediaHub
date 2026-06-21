package com.LkDev.MediaHub.Music.Service;

import com.LkDev.MediaHub.Api.ConsumeApi;
import com.LkDev.MediaHub.Music.Repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final ConsumeApi consumeApi;
    private final MusicRepository musicRepository;

    // ADICIONAR MÚSICA
}
