package com.rs.fer.user.mapper;

import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.request.EditRatingRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T08:05:18+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class EditRatingRequestMapperImpl implements EditRatingRequestMapper {

    @Override
    public Rating mapToRating(EditRatingRequest request) {
        if ( request == null ) {
            return null;
        }

        Rating rating = new Rating();

        rating.setRatingId( request.getRatingId() );
        rating.setReviewedBy( request.getReviewerId() );
        rating.setComments( request.getComments() );
        rating.setRating( request.getRating() );
        rating.setUserId( request.getUserId() );

        return rating;
    }
}
