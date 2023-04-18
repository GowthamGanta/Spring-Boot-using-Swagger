package com.rs.fer.user.mapper;

import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.request.SaveRatingRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-18T16:53:21+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class SaveRatingRequestMapperImpl implements SaveRatingRequestMapper {

    @Override
    public Rating mapToRating(SaveRatingRequest request) {
        if ( request == null ) {
            return null;
        }

        Rating rating = new Rating();

        rating.setReviewedBy( request.getReviewerId() );
        rating.setComments( request.getComments() );
        rating.setRating( request.getRating() );
        rating.setUserId( request.getUserId() );

        return rating;
    }
}
